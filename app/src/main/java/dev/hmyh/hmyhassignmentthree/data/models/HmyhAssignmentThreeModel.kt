package dev.hmyh.hmyhassignmentthree.data.models

import androidx.lifecycle.LiveData
import dev.hmyh.hmyhassignmentthree.data.vos.LatestMovieVO
import dev.hmyh.hmyhassignmentthree.data.vos.NowPlayingMovieVO
import dev.hmyh.hmyhassignmentthree.data.vos.PopularMovieVO
import dev.hmyh.hmyhassignmentthree.data.vos.TopRatedMovieVO

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

    fun loadPopularMovie(
        onSuccess: (popularMovie: PopularMovieVO)->Unit,
        onFailure: (String)->Unit
    )

    fun getPopularMovie(): LiveData<PopularMovieVO>

    fun loadTopRatedMovie(
        onSuccess: (topRatedMovie: TopRatedMovieVO)->Unit,
        onFailure: (String) -> Unit
    )

    fun getTopRatedMovie(): LiveData<TopRatedMovieVO>

}