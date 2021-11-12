package dev.hmyh.hmyhassignmentthree.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import dev.hmyh.hmyhassignmentthree.R
import dev.hmyh.hmyhassignmentthree.data.vos.MovieDetailVO
import dev.hmyh.hmyhassignmentthree.data.vos.MovieVideoListVO
import dev.hmyh.hmyhassignmentthree.utils.PHOTO_PATH
import dev.hmyh.hmyhassignmentthree.utils.getApiMovieDate
import dev.hmyh.hmyhassignmentthree.viewmodels.DetailFragmentViewModel
import kotlinx.android.synthetic.main.fragment_detail.*
import android.content.Intent
import android.net.Uri
import dev.hmyh.hmyhassignmentthree.utils.getApiMovieDatePremier


class DetailFragment: BaseFragment() {

    private lateinit var mDetailFragmentViewModel: DetailFragmentViewModel
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewModel()
        setUpListener()
        setUpOnUiReady()
        setUpDataObservation()
    }

    private fun setUpDataObservation() {

        var movieId = args.movieId

        mDetailFragmentViewModel.loadMovieDetailById(movieId)

        mDetailFragmentViewModel.getMovieDetailById(movieId).observe(viewLifecycleOwner, Observer {
            it?.let { movieDetail->
                bindData(movieDetail)
            }
        })

        mDetailFragmentViewModel.getMovieVideo(movieId).observe(viewLifecycleOwner, Observer {
            it?.let { movieVideo->
                movieVideo.movieVideoList?.let { vidoeList->
                    bindMovieVideoList(vidoeList)
                }
            }
        })

    }

    private fun bindMovieVideoList(videoList: List<MovieVideoListVO>) {

        rlPlayTrailer.setOnClickListener {

            if (videoList.isEmpty()){

                showAlertDialog("Hmyh Assignment Three","The video isn't available to play"){

                }
            }
            else{
                videoList[0].key?.let { key->
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("http://www.youtube.com/watch?v=$key")
                        )
                    )
                }
            }
        }

    }

    private fun bindData(movieDetail: MovieDetailVO) {
        Glide.with(this)
            .load(PHOTO_PATH+movieDetail.backDropPath)
            .into(ivLatestMovieDetailBg)
        Glide.with(this)
            .load(PHOTO_PATH+movieDetail.posterPath)
            .into(ivMovieImageDetail)
        tvMovieDetailTitle.text = movieDetail.title
        tvMovieDetailRating.text = movieDetail.voteAverage.toString()
        tvMovieDetailYear.text = getApiMovieDate(movieDetail.releaseDate.toString())

        var genreList = movieDetail.genreList?.map { it.name }
        var genre = genreList?.joinToString(", ")
        tvGenre.text = genre ?: ""

        tvOverview.text = movieDetail.overView ?: ""
        tvOriginalTitle.text = movieDetail.originalTitle ?: ""

        var productionCountryList = movieDetail.productCountryList?.map { it.name }
        var productCountry = productionCountryList?.joinToString(", ")
        tvProduction.text = productCountry ?: ""

        tvPremiere.text = getApiMovieDatePremier(movieDetail.releaseDate.toString())

        rlGoHome.setOnClickListener {
            movieDetail.homePage?.let { homePage->

                if (homePage.isEmpty()){
//                    startActivity(
//                        Intent(
//                            Intent.ACTION_VIEW,
//                            Uri.parse("http://www.google.com")
//                        )
//                    )

                    showAlertDialog("Hmyh Assignment Three","There is no home page"){

                    }

                }
                else{
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("$homePage")
                        )
                    )
                }
            }
        }
    }

    private fun setUpOnUiReady() {
        mDetailFragmentViewModel.onUiReady()
    }

    private fun setUpViewModel() {
        mDetailFragmentViewModel = ViewModelProviders.of(this).get(DetailFragmentViewModel::class.java)
    }

    private fun setUpListener() {
        ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}