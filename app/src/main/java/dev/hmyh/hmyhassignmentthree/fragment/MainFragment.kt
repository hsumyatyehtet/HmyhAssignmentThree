package dev.hmyh.hmyhassignmentthree.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import dev.hmyh.hmyhassignmentthree.R
import dev.hmyh.hmyhassignmentthree.adapter.*
import dev.hmyh.hmyhassignmentthree.data.vos.LatestMovieVO
import dev.hmyh.hmyhassignmentthree.data.vos.NowPlayingMovieListVO
import dev.hmyh.hmyhassignmentthree.viewmodels.MainFragmentViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainFragment : Fragment() {

    private lateinit var mMainFragmentViewModel: MainFragmentViewModel

    private lateinit var mNowPlayingMovieListAdapter: NowPlayingMovieListAdapter
    private lateinit var mPopularMovieListAdapter: PopularMovieListAdapter
    private lateinit var mTopRatedMovieListAdapter: TopRatedMovieListAdapter
    private lateinit var mUpcomingMovieListAdapter: UpcomingMovieListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewModel()
        setCurrentDate()
        setUpRecyclerView()

        setUpOnUiReady()
        setUpDataObservations()
    }

    private fun setUpViewModel() {
        mMainFragmentViewModel = ViewModelProviders.of(this).get(MainFragmentViewModel::class.java)
    }

    private fun setUpOnUiReady() {
        mMainFragmentViewModel.onUiReady()
    }

    private fun setUpDataObservations() {
        mMainFragmentViewModel.getLatestMovie()
            .observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                it?.let { latestMovie ->
                    bindLatestMovieData(latestMovie)
                }
            })

        mMainFragmentViewModel.getNowPlayingMovie()
            .observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                it?.let { nowPlayingMovieVO ->
                    nowPlayingMovieVO.movieList?.let {
                            nowPlayingMovieList->
                        mNowPlayingMovieListAdapter.setNewData(nowPlayingMovieList)
                    }
                }

            })
    }

    private fun bindLatestMovieData(latestMovie: LatestMovieVO) {
        var photoPath = "http://image.tmdb.org/t/p/w500"
        Glide.with(this)
            .load(photoPath + latestMovie.posterPath)
            .into(ivLatestMovie)
        tvLatestMovieTitle.text = latestMovie.title ?: ""
    }

    private fun setUpRecyclerView() {

        mNowPlayingMovieListAdapter = NowPlayingMovieListAdapter()
        val nowPlayingLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvNowPlayingMovie.layoutManager = nowPlayingLayoutManager
        rvNowPlayingMovie.adapter = mNowPlayingMovieListAdapter

        mPopularMovieListAdapter = PopularMovieListAdapter()
        val popularLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvPopularMovie.layoutManager = popularLayoutManager
        rvPopularMovie.adapter = mPopularMovieListAdapter
        mPopularMovieListAdapter.setNewData(
            mutableListOf(
                NowPlayingMovieListVO(), NowPlayingMovieListVO(), NowPlayingMovieListVO(),
                NowPlayingMovieListVO(), NowPlayingMovieListVO()
            )
        )

        mTopRatedMovieListAdapter = TopRatedMovieListAdapter()
        val topRatedLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvTopRatedMovie.layoutManager = topRatedLayoutManager
        rvTopRatedMovie.adapter = mTopRatedMovieListAdapter
        mTopRatedMovieListAdapter.setNewData(
            mutableListOf(
                NowPlayingMovieListVO(), NowPlayingMovieListVO(), NowPlayingMovieListVO(),
                NowPlayingMovieListVO(), NowPlayingMovieListVO()
            )
        )

        mUpcomingMovieListAdapter = UpcomingMovieListAdapter()
        val upcomingLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvUpcomingMovie.layoutManager = upcomingLayoutManager
        rvUpcomingMovie.adapter = mUpcomingMovieListAdapter
        mUpcomingMovieListAdapter.setNewData(
            mutableListOf(
                NowPlayingMovieListVO(), NowPlayingMovieListVO(), NowPlayingMovieListVO(),
                NowPlayingMovieListVO(), NowPlayingMovieListVO()
            )
        )
    }

    private fun setCurrentDate() {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("EEE, MMM d");
        val date = dateFormat.format(calendar.time);
        tvCurrentDate.text = date;
    }

}