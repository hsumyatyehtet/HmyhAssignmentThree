package dev.hmyh.hmyhassignmentthree.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.hmyh.hmyhassignmentthree.data.models.HmyhAssignmentThreeModel
import dev.hmyh.hmyhassignmentthree.data.models.impl.HmyhAssignmentThreeModelImpl
import dev.hmyh.hmyhassignmentthree.data.vos.MovieVideoVO
import dev.hmyh.hmyhassignmentthree.delegate.MovieListViewDelegate

class MovieListFragmentViewModel: ViewModel(),MovieListViewDelegate{

    private val mModel: HmyhAssignmentThreeModel = HmyhAssignmentThreeModelImpl

    private val navigateToMovieViewDetail: MutableLiveData<String> = MutableLiveData()

    fun loadMovieDetailById(movieId: Long){
        mModel.loadMovieVideo(movieId,onSuccess = {},onFailure = {})
    }

    fun getMovieVideo(movieId: Long): LiveData<MovieVideoVO> {
        return mModel.getMovieVideo(movieId)
    }

    override fun onTapMovieView(key: String) {
        navigateToMovieViewDetail.postValue(key)
    }

    fun getNavigateToMovieViewLiveData(): LiveData<String> {
        return navigateToMovieViewDetail
    }

}