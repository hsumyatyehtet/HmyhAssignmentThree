package dev.hmyh.hmyhassignmentthree.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dev.hmyh.hmyhassignmentthree.data.models.HmyhAssignmentThreeModel
import dev.hmyh.hmyhassignmentthree.data.models.impl.HmyhAssignmentThreeModelImpl
import dev.hmyh.hmyhassignmentthree.data.vos.MovieDetailVO
import dev.hmyh.hmyhassignmentthree.data.vos.MovieVideoVO

class DetailFragmentViewModel: ViewModel() {

    private val mModel: HmyhAssignmentThreeModel = HmyhAssignmentThreeModelImpl

    private val mMovieVideo: LiveData<MovieVideoVO> = mModel.getMovieVideo()

    fun onUiReady(){

    }

    fun loadMovieDetailById(movieId: Long){
        mModel.loadMovieDetail(movieId,onSuccess = {},onFailure = {})
        mModel.loadMovieVideo(movieId,onSuccess = {},onFailure = {})
    }

    fun getMovieDetailById(movieId: Long): LiveData<MovieDetailVO>{
        return mModel.getMovieDetailById(movieId)
    }

    fun getMovieVideo(): LiveData<MovieVideoVO>{
        return mMovieVideo
    }

}