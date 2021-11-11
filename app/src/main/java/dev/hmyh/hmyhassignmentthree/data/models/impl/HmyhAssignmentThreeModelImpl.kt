package dev.hmyh.hmyhassignmentthree.data.models.impl

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.hmyh.hmyhassignmentthree.data.models.BaseAppModel
import dev.hmyh.hmyhassignmentthree.data.models.HmyhAssignmentThreeModel
import dev.hmyh.hmyhassignmentthree.data.vos.LatestMovieVO
import dev.hmyh.hmyhassignmentthree.utils.API_KEY_DATA
import dev.hmyh.hmyhassignmentthree.utils.subscribeDBWithCompletable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object HmyhAssignmentThreeModelImpl: BaseAppModel(),HmyhAssignmentThreeModel {

    @SuppressLint("CheckResult")
    override fun loadLatestMovie(
        onSuccess: (latestMovie: LatestMovieVO) -> Unit,
        onFailure: (String) -> Unit
    ):LiveData<LatestMovieVO> {

        var liveData=MutableLiveData<LatestMovieVO>()

        mApi.loadLatestMovie(API_KEY_DATA).subscribeOn(
            Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let { latestMovie ->
                    mDatabase.latestMovieDao().insertLatestMovie(latestMovie).subscribeDBWithCompletable()
                    onSuccess(latestMovie)
                }
            }, {

            })
        return liveData
    }

    override fun getLatestMovie(): LiveData<LatestMovieVO> {
        return mDatabase.latestMovieDao().getLatestMovie()
    }

}