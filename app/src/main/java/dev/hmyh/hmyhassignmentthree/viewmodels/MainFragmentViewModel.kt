package dev.hmyh.hmyhassignmentthree.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dev.hmyh.hmyhassignmentthree.data.models.HmyhAssignmentThreeModel
import dev.hmyh.hmyhassignmentthree.data.models.impl.HmyhAssignmentThreeModelImpl
import dev.hmyh.hmyhassignmentthree.data.vos.LatestMovieVO
import dev.hmyh.hmyhassignmentthree.data.vos.NowPlayingMovieVO

class MainFragmentViewModel : ViewModel() {

    private val mModel: HmyhAssignmentThreeModel = HmyhAssignmentThreeModelImpl

    private val mLatestMovie: LiveData<LatestMovieVO> = mModel.getLatestMovie()
    private val mNowPlayingMovie: LiveData<NowPlayingMovieVO> = mModel.getNowPlayingMovie()

    fun onUiReady() {
        mModel.loadLatestMovie(
            onSuccess = {

            }, onFailure = {

            })
        mModel.loadNowPlayingMovie(onSuccess = {

        },onFailure = {

        })
    }

    fun getLatestMovie(): LiveData<LatestMovieVO> {
        return mLatestMovie
    }

    fun getNowPlayingMovie(): LiveData<NowPlayingMovieVO>{
        return mNowPlayingMovie
    }

}