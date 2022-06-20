package dev.hmyh.hmyhassignmentthree.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.hmyh.hmyhassignmentthree.data.models.HmyhAssignmentThreeModel
import dev.hmyh.hmyhassignmentthree.data.models.impl.HmyhAssignmentThreeModelImpl
import dev.hmyh.hmyhassignmentthree.data.vos.MetaVO
import dev.hmyh.hmyhassignmentthree.data.vos.MovieListVO
import dev.hmyh.hmyhassignmentthree.data.vos.SearchMovieVO
import dev.hmyh.hmyhassignmentthree.delegate.MovieListDelegate
import dev.hmyh.hmyhassignmentthree.utils.BASE_URL
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SearchFragmentViewModel : ViewModel(), MovieListDelegate {

    private val mModel: HmyhAssignmentThreeModel = HmyhAssignmentThreeModelImpl

    private var searchMovie: MutableLiveData<SearchMovieVO> = MutableLiveData()
    private val navigateToMovieDetail: MutableLiveData<Long> = MutableLiveData()

    private val mMovie = ArrayList<MovieListVO>()
    private val mMovieListLiveData = MutableLiveData<List<MovieListVO>>()

    private var progressLiveData: MutableLiveData<Int> = MutableLiveData<Int>()

    private var mErrorMessage: MutableLiveData<String> = MutableLiveData<String>()

    fun loadSearchMovie(searchWord: String) {

        mModel.loadSearchMovie(searchWord,
            onSuccess = { movie ->
                searchMovie.postValue(movie)
                movie.movieList?.let {
                    mMovie.clear()
                    mMovie.addAll(it)
                    mMovieListLiveData.value = mMovie
                }
            },
            onFailure = {
                GlobalScope.launch {
                    mErrorMessage.postValue(it)
                }
            }
        )
    }

    fun loadMoreSearchMovie(searchWord: String) {
        var page = 0L
        var totalPage = 0L

        searchMovie.value?.page?.let {
            page = it
        }
        searchMovie.value?.totalPages?.let {
            totalPage = it
        }

        if (page <= totalPage) {
            page++
            progressLiveData.postValue(1)
            mModel.loadMoreSearchMovie(BASE_URL, searchWord, page,
                onSuccess = {movie->
                    searchMovie.postValue(movie)
                    movie.movieList?.let {
                        mMovie.addAll(it)
                        mMovieListLiveData.value = mMovie
                    }
                    progressLiveData.postValue(0)
                },
                onFailure = {
                    progressLiveData.postValue(0)
                    GlobalScope.launch {
                        mErrorMessage.postValue(it)
                    }
                })
        }
    }

    fun getShowOrHideProgress(): MutableLiveData<Int>{
        return progressLiveData
    }

    fun getSearchMovieList(): MutableLiveData<List<MovieListVO>> {
        return mMovieListLiveData
    }

    //delegate override function
    override fun onTapMovieItem(movieId: Long) {
        navigateToMovieDetail.postValue(movieId)
    }

    fun getNavigateToMovieDetailLiveData(): LiveData<Long> {
        return navigateToMovieDetail
    }

    fun getErrorMessage(): LiveData<String>{
        return mErrorMessage
    }

}