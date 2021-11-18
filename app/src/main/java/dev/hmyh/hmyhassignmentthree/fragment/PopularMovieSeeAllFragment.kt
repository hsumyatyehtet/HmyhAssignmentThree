package dev.hmyh.hmyhassignmentthree.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.hmyh.hmyhassignmentthree.R
import dev.hmyh.hmyhassignmentthree.adapter.PopularMovieListSeeAllAdapter
import dev.hmyh.hmyhassignmentthree.data.vos.MovieListVO
import dev.hmyh.hmyhassignmentthree.utils.getBundleMovieDetail
import dev.hmyh.hmyhassignmentthree.viewmodels.PopularMovieSeeAllViewModel
import kotlinx.android.synthetic.main.fragment_see_all.*

class PopularMovieSeeAllFragment: BaseFragment() {

    private lateinit var mViewModel: PopularMovieSeeAllViewModel

    private lateinit var mAdapter: PopularMovieListSeeAllAdapter

    var isListEndReached = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_see_all,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvSeeAllTitle.text = "Popular Movie List"

        setUpViewModel()
        setUpRecyclerView()
        setUpListener()
        setUpOnUiReady()
        setUpDataObservations()
    }

    private fun setUpViewModel() {
        mViewModel = ViewModelProviders.of(this)[PopularMovieSeeAllViewModel::class.java]
    }

    private fun setUpRecyclerView() {
        mAdapter = PopularMovieListSeeAllAdapter(mViewModel)
        rvSeeAll.layoutManager = GridLayoutManager(context,2)
        rvSeeAll.adapter = mAdapter

    }

    private fun setUpListener() {
        ivBackSeeAll.setOnClickListener {
            findNavController().popBackStack()
        }

        rvSeeAll.addOnScrollListener(object : RecyclerView.OnScrollListener(){

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val visibleItemCount = rvSeeAll.layoutManager!!.childCount
                val totalItemCount = rvSeeAll.layoutManager!!.itemCount
                val pastVisibleItems = (rvSeeAll.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

                if (visibleItemCount + pastVisibleItems < totalItemCount) {
                    isListEndReached = false
                }
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (newState == RecyclerView.SCROLL_STATE_IDLE
                    && (recyclerView.layoutManager as LinearLayoutManager)
                        .findLastCompletelyVisibleItemPosition() == recyclerView.adapter!!.itemCount - 1
                    && !isListEndReached
                ) {
                    isListEndReached = true
                    mViewModel.loadMorePopularMovie()
                }
            }
        })

    }

    private fun setUpOnUiReady(){
        mViewModel.loadPopularMovie()
    }

    private fun setUpDataObservations(){
        mViewModel.getPopularMovieList().observe(viewLifecycleOwner, Observer {
            it?.let { movieList->
                mAdapter.setNewData(movieList as MutableList<MovieListVO>)
            }
        })

        mViewModel.getShowOrHideProgress().observe(viewLifecycleOwner, Observer {
            it?.let { data->
                if (data==1){
                    showProgressDialog()
                }
                else{
                    hideProgressDialog()
                }
            }
        })

        mViewModel.getNavigateToMovieDetail().observe(viewLifecycleOwner,
            androidx.lifecycle.Observer {id->
                if (viewLifecycleOwner.lifecycle.currentState == Lifecycle.State.RESUMED){
                    id?.let {
                        findNavController().navigate(
                            R.id.action_popularMovieSeeAllFragment_to_detailFragment,
                            getBundleMovieDetail(it)
                        )
                    }
                }

            })

    }

}