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
import dev.hmyh.hmyhassignmentthree.R
import dev.hmyh.hmyhassignmentthree.adapter.SearchMovieListAdapter
import dev.hmyh.hmyhassignmentthree.data.vos.MovieListVO
import dev.hmyh.hmyhassignmentthree.utils.getBundleMovieDetail
import dev.hmyh.hmyhassignmentthree.viewmodels.SearchFragmentViewModel
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment: Fragment() {

    private lateinit var mSearchFragmentViewModel: SearchFragmentViewModel

    private lateinit var mSearchMovieListAdapter: SearchMovieListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewModel()
        setUpRecyclerView()
        setUpListener()
        setUpDataObservation()
    }

    private fun setUpListener() {

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
    }

    private fun setUpRecyclerView() {
        mSearchMovieListAdapter = SearchMovieListAdapter(mSearchFragmentViewModel)
        val layoutManager = GridLayoutManager(context,2)
        rvSearch.layoutManager = layoutManager
        rvSearch.adapter = mSearchMovieListAdapter

    }

    private fun setUpDataObservation() {
        mSearchFragmentViewModel.getSearchMovie().observe(viewLifecycleOwner, Observer {
            it?.let { searchMovie->
                searchMovie.movieList?.let { movieList->
                    mSearchMovieListAdapter.setNewData(movieList)
                }
            }
        })

        mSearchFragmentViewModel.getNavigateToMovieDetailLiveData().observe(viewLifecycleOwner,
            androidx.lifecycle.Observer {id->
                if (viewLifecycleOwner.lifecycle.currentState == Lifecycle.State.RESUMED){
                    id?.let {
                        findNavController().navigate(
                            R.id.action_searchFragment_to_detailFragment,
                            getBundleMovieDetail(it)
                        )
                    }
                }

            })


    }

    private fun setUpViewModel() {
        mSearchFragmentViewModel = ViewModelProviders.of(this)[SearchFragmentViewModel::class.java]
    }

}