package dev.hmyh.hmyhassignmentthree.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import dev.hmyh.hmyhassignmentthree.R
import dev.hmyh.hmyhassignmentthree.adapter.*
import dev.hmyh.hmyhassignmentthree.data.vos.MovieListVO
import dev.hmyh.hmyhassignmentthree.utils.PHOTO_PATH
import dev.hmyh.hmyhassignmentthree.utils.getBundleMovieDetail
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
        setUpListener()

        setUpOnUiReady()
        setUpDataObservations()
    }

    private fun setUpListener() {
        ivSearch.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_searchFragment)
        }

        tvNowPlayingSeeAll.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_nowPlayingMovieSeeAllFragment)
        }

        tvPopularSeeAll.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_popularMovieSeeAllFragment)
        }

        tvTopRatedSeeAll.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_topRatedMovieSeeAllFragment)
        }

    }

    private fun setUpViewModel() {
        mMainFragmentViewModel = ViewModelProviders.of(this).get(MainFragmentViewModel::class.java)
    }

    private fun setUpOnUiReady() {
        mMainFragmentViewModel.onUiReady()
    }

    private fun setUpDataObservations() {

        mMainFragmentViewModel.getNowPlayingMovie()
            .observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                it?.let { nowPlayingMovieVO ->
                    nowPlayingMovieVO.movieList?.let {
                            nowPlayingMovieList->
                        mNowPlayingMovieListAdapter.setNewData(nowPlayingMovieList)
                    }
                }

            })

        mMainFragmentViewModel.getPopularMovie()
            .observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                it?.let { popularMovie->
                    popularMovie.movieList?.let { movieList->
                        mPopularMovieListAdapter.setNewData(movieList)
                    }
                }
            })

        mMainFragmentViewModel.getTopRatedMovie()
            .observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                it?.let { topRatedMovie->
                    topRatedMovie.movieList?.let { movieList->
                        mTopRatedMovieListAdapter.setNewData(movieList)
                    }
                }
            })

        mMainFragmentViewModel.getUpComingMovie()
            .observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                it?.let { upComingMovie->
                    upComingMovie.movieList?.let { movieList->
                        mUpcomingMovieListAdapter.setNewData(movieList)
                    }
                }
            })

        mMainFragmentViewModel.getNavigateToMovieDetailLiveData().observe(viewLifecycleOwner,
            androidx.lifecycle.Observer {id->
                if (viewLifecycleOwner.lifecycle.currentState == Lifecycle.State.RESUMED){
                    id?.let {
                        findNavController().navigate(
                            R.id.action_mainFragment_to_detailFragment,
                            getBundleMovieDetail(it)
                        )
                    }
                }

            })

    }

    private fun setUpRecyclerView() {

        mNowPlayingMovieListAdapter = NowPlayingMovieListAdapter(mMainFragmentViewModel)
        val nowPlayingLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvNowPlayingMovie.layoutManager = nowPlayingLayoutManager
        rvNowPlayingMovie.adapter = mNowPlayingMovieListAdapter

        mPopularMovieListAdapter = PopularMovieListAdapter(mMainFragmentViewModel)
        val popularLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvPopularMovie.layoutManager = popularLayoutManager
        rvPopularMovie.adapter = mPopularMovieListAdapter

        mTopRatedMovieListAdapter = TopRatedMovieListAdapter(mMainFragmentViewModel)
        val topRatedLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvTopRatedMovie.layoutManager = topRatedLayoutManager
        rvTopRatedMovie.adapter = mTopRatedMovieListAdapter

        mUpcomingMovieListAdapter = UpcomingMovieListAdapter(mMainFragmentViewModel)
        val upcomingLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvUpcomingMovie.layoutManager = upcomingLayoutManager
        rvUpcomingMovie.adapter = mUpcomingMovieListAdapter

    }

    private fun setCurrentDate() {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("EEE, MMM d");
        val date = dateFormat.format(calendar.time);
        tvCurrentDate.text = date;
    }

}