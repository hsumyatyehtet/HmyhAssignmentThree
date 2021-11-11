package dev.hmyh.hmyhassignmentthree.data.models

import androidx.lifecycle.LiveData
import dev.hmyh.hmyhassignmentthree.data.vos.LatestMovieVO
import dev.hmyh.hmyhassignmentthree.data.vos.NowPlayingMovieVO

interface HmyhAssignmentThreeModel {

    fun loadLatestMovie(
        onSuccess: (latestMovie: LatestMovieVO)->Unit,
        onFailure: (String)->Unit
    ): LiveData<LatestMovieVO>

    fun getLatestMovie(): LiveData<LatestMovieVO>

    fun loadNowPlayingMovie(
        onSuccess: (nowPlayingMovie: NowPlayingMovieVO)->Unit,
        onFailure: (String) -> Unit
    ): LiveData<NowPlayingMovieVO>

    fun getNowPlayingMovie(): LiveData<NowPlayingMovieVO>

}