package dev.hmyh.hmyhassignmentthree.data.models.impl

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.hmyh.hmyhassignmentthree.data.models.BaseAppModel
import dev.hmyh.hmyhassignmentthree.data.models.HmyhAssignmentThreeModel
import dev.hmyh.hmyhassignmentthree.data.vos.LatestMovieVO
import dev.hmyh.hmyhassignmentthree.data.vos.NowPlayingMovieVO
import dev.hmyh.hmyhassignmentthree.data.vos.PopularMovieVO
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

    @SuppressLint("CheckResult")
    override fun loadNowPlayingMovie(
        onSuccess: (nowPlayingMovie: NowPlayingMovieVO) -> Unit,
        onFailure: (String) -> Unit
    ): LiveData<NowPlayingMovieVO> {
        var liveData=MutableLiveData<NowPlayingMovieVO>()

        mApi.loadNowPlayingMovieList(API_KEY_DATA).subscribeOn(
            Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let { nowPlayingMovie ->
                    mDatabase.nowPlayingMovieDao().insertNowPlayingMovie(nowPlayingMovie).subscribeDBWithCompletable()
                    onSuccess(nowPlayingMovie)
                }
            }, {

            })
        return liveData
    }

    override fun getNowPlayingMovie(): LiveData<NowPlayingMovieVO> {
       return mDatabase.nowPlayingMovieDao().getNowPlayingMovie()
    }

    @SuppressLint("CheckResult")
    override fun loadPopularMovie(
        onSuccess: (popularMovie: PopularMovieVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mApi.loadPopularMovieList(API_KEY_DATA).subscribeOn(
            Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let { popularMovie ->
                    mDatabase.popularMovieDao().insertPopularMovie(popularMovie).subscribeDBWithCompletable()
                    onSuccess(popularMovie)
                }
            }, {

            })
    }

    override fun getPopularMovie(): LiveData<PopularMovieVO> {
        return mDatabase.popularMovieDao().getPopularMovie()
    }

}