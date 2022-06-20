package dev.hmyh.hmyhassignmentthree.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.hmyh.hmyhassignmentthree.R
import dev.hmyh.hmyhassignmentthree.adapter.SearchMovieListAdapter
import dev.hmyh.hmyhassignmentthree.data.vos.MovieListVO
import dev.hmyh.hmyhassignmentthree.utils.getBundleMovieDetail
import dev.hmyh.hmyhassignmentthree.viewmodels.SearchFragmentViewModel
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : BaseFragment() {

    private lateinit var mSearchFragmentViewModel: SearchFragmentViewModel

    private lateinit var mSearchMovieListAdapter: SearchMovieListAdapter

    var isListEndReached = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewModel()
        setUpRecyclerView()
        setUpListener()
        setUpDataObservation()
    }

    private fun setUpListener() {

        swipeRefreshMovieSearch.setOnRefreshListener {
            swipeRefreshMovieSearch.isRefreshing = false
            etMovieSearch.text?.clear()
            mSearchFragmentViewModel.loadSearchMovie("")
        }


        val handler = Handler(Looper.getMainLooper())
        etMovieSearch.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
                handler.removeCallbacksAndMessages(null)
                handler.postDelayed({
                    s?.toString()?.let { searchWord ->
                        onChangeTextAfterSecond(searchWord)
                    }
                }, 600)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        })

    }

    private fun onChangeTextAfterSecond(searchWord: String) {
        mSearchFragmentViewModel.loadSearchMovie(searchWord)

        rvSearch.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val visibleItemCount = rvSearch.layoutManager!!.childCount
                val totalItemCount = rvSearch.layoutManager!!.itemCount
                val pastVisibleItems =
                    (rvSearch.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

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

                    mSearchFragmentViewModel.loadMoreSearchMovie(searchWord)

                }
            }

        })

    }

    private fun setUpRecyclerView() {
        mSearchMovieListAdapter = SearchMovieListAdapter(mSearchFragmentViewModel)
        val layoutManager = GridLayoutManager(context, 2)
        rvSearch.layoutManager = layoutManager
        rvSearch.adapter = mSearchMovieListAdapter

    }

    private fun setUpDataObservation() {

        mSearchFragmentViewModel.getSearchMovieList().observe(viewLifecycleOwner, Observer {
            it?.let { searchMovieList ->
                var mMovieList: MutableList<MovieListVO> = mutableListOf()
                mMovieList.addAll(searchMovieList.distinctBy { movieDistinctList ->
                    movieDistinctList.id
                })
                llNoResultContainer.visibility = View.GONE
                rvSearch.visibility = View.VISIBLE
                mSearchMovieListAdapter.setNewData(mMovieList)
            }
        })

        mSearchFragmentViewModel.getNavigateToMovieDetailLiveData().observe(viewLifecycleOwner,
            androidx.lifecycle.Observer { id ->
                if (viewLifecycleOwner.lifecycle.currentState == Lifecycle.State.RESUMED) {
                    id?.let {
                        findNavController().navigate(
                            R.id.action_searchFragment_to_detailFragment,
                            getBundleMovieDetail(it)
                        )
                    }
                }

            })

        mSearchFragmentViewModel.getShowOrHideProgress().observe(viewLifecycleOwner, Observer {
            it?.let { data ->
                if (data == 1) {
                    showProgressDialog()
                } else {
                    hideProgressDialog()
                }
            }
        })

        mSearchFragmentViewModel.getErrorMessage().observe(viewLifecycleOwner, Observer {
            it?.let { errorMessage->
                if (errorMessage.contains("HTTP 422")){
                    llNoResultContainer.visibility = View.VISIBLE
                    rvSearch.visibility = View.GONE
                }
                else{
                    llNoResultContainer.visibility = View.GONE
                    rvSearch.visibility = View.VISIBLE
                }
            }
        })

    }

    private fun setUpViewModel() {
        mSearchFragmentViewModel = ViewModelProviders.of(this)[SearchFragmentViewModel::class.java]
    }

}