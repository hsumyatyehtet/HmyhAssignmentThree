package dev.hmyh.hmyhassignmentthree.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dev.hmyh.hmyhassignmentthree.data.models.HmyhAssignmentThreeModel
import dev.hmyh.hmyhassignmentthree.data.models.impl.HmyhAssignmentThreeModelImpl
import dev.hmyh.hmyhassignmentthree.data.vos.LatestMovieVO

class MainFragmentViewModel : ViewModel() {

    private val mModel: HmyhAssignmentThreeModel = HmyhAssignmentThreeModelImpl

    private val mLatestMovie: LiveData<LatestMovieVO> = mModel.getLatestMovie()

    fun onUiReady() {
        mModel.loadLatestMovie(
            onSuccess = {

            }, onFailure = {

            })
    }

    fun getLatestMovie(): LiveData<LatestMovieVO> {
        return mLatestMovie
    }

}