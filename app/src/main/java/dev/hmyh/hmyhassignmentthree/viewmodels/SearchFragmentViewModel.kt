package dev.hmyh.hmyhassignmentthree.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.hmyh.hmyhassignmentthree.data.models.HmyhAssignmentThreeModel
import dev.hmyh.hmyhassignmentthree.data.models.impl.HmyhAssignmentThreeModelImpl
import dev.hmyh.hmyhassignmentthree.data.vos.SearchMovieVO
import dev.hmyh.hmyhassignmentthree.delegate.MovieListDelegate

class SearchFragmentViewModel : ViewModel(),MovieListDelegate{

    private val mModel: HmyhAssignmentThreeModel = HmyhAssignmentThreeModelImpl

    private val searchMovie: MutableLiveData<SearchMovieVO> = MutableLiveData()
    private val navigateToMovieDetail: MutableLiveData<Long> = MutableLiveData()

    fun loadSearchMovie(searchWord: String) {
        mModel.loadSearchMovie(searchWord,
            onSuccess = {
                        searchMovie.postValue(it)
            },
            onFailure = {

            })
    }

    fun getSearchMovie(): LiveData<SearchMovieVO>{
        return searchMovie
    }

    //delegate override function
    override fun onTapMovieItem(movieId: Long) {
        navigateToMovieDetail.postValue(movieId)
    }

    fun getNavigateToMovieDetailLiveData(): LiveData<Long>{
        return navigateToMovieDetail
    }

}