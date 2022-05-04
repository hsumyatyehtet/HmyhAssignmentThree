package dev.hmyh.hmyhassignmentthree.fragment

import android.graphics.Movie
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import dev.hmyh.hmyhassignmentthree.R
import dev.hmyh.hmyhassignmentthree.adapter.MovieListViewAdapter
import dev.hmyh.hmyhassignmentthree.data.vos.MovieVideoListVO
import dev.hmyh.hmyhassignmentthree.utils.getBundleMovieVideoKey
import dev.hmyh.hmyhassignmentthree.viewmodels.MovieListFragmentViewModel
import kotlinx.android.synthetic.main.fragment_movie_list.*

class MovieListViewFragment : BaseFragment() {

    private lateinit var mModel: MovieListFragmentViewModel
    private lateinit var mAdapter: MovieListViewAdapter

    private val args: MovieListViewFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewModel()
        setUpRecyclerView()
        setUpListener()
        setUpDataObservations()
    }

    private fun setUpViewModel() {
        mModel = ViewModelProviders.of(this)[MovieListFragmentViewModel::class.java]
    }

    private fun setUpListener(){
        ivBackMovieList.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setUpRecyclerView() {
        mAdapter = MovieListViewAdapter(mModel)
        rvMovieViewList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvMovieViewList.adapter = mAdapter

    }

    private fun setUpDataObservations() {
        var movieId = args.movieId

        mModel.loadMovieDetailById(movieId)

        mModel.getMovieVideo(movieId).observe(viewLifecycleOwner, Observer {
            it?.let { movieVideo ->
                movieVideo.movieVideoList?.let { vidoeList ->
                    bindMovieVideoList(vidoeList)
                }
            }
        })

        mModel.getNavigateToMovieViewLiveData().observe(viewLifecycleOwner, Observer {movieKey->
            if (viewLifecycleOwner.lifecycle.currentState == Lifecycle.State.RESUMED){
                movieKey?.let { key->
                    findNavController().navigate(
                        R.id.action_movieListFragment_to_movieViewFragment,
                        getBundleMovieVideoKey(key)
                    )
                }
            }
        })
    }

    private fun bindMovieVideoList(videoList: List<MovieVideoListVO>) {
        mAdapter.setNewData(videoList as MutableList<MovieVideoListVO>)
    }

}