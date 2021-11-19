package dev.hmyh.hmyhassignmentthree.data.models

import androidx.lifecycle.LiveData
import dev.hmyh.hmyhassignmentthree.data.vos.*

interface HmyhAssignmentThreeModel {

    fun loadNowPlayingMovie(
        onSuccess: (nowPlayingMovie: NowPlayingMovieVO) -> Unit,
        onFailure: (String) -> Unit
    ): LiveData<NowPlayingMovieVO>

    fun getNowPlayingMovie(): LiveData<NowPlayingMovieVO>

    fun loadMoreNowPlayingMovie(
        url: String,
        page: Long,
        onSuccess: (nowPlayingMovie: NowPlayingMovieVO) -> Unit,
        onFailure: (String) -> Unit
    )

    fun loadPopularMovie(
        onSuccess: (popularMovie: PopularMovieVO) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getPopularMovie(): LiveData<PopularMovieVO>

    fun loadMorePopularMovie(
        url: String,
        page: Long,
        onSuccess: (popularMovie: PopularMovieVO) -> Unit,
        onFailure: (String) -> Unit
    )

    fun loadTopRatedMovie(
        onSuccess: (topRatedMovie: TopRatedMovieVO) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getTopRatedMovie(): LiveData<TopRatedMovieVO>

    fun loadMoreTopRatedMovie(
        url: String,
        page: Long,
        onSuccess: (topRatedMovie: TopRatedMovieVO)->Unit,
        onFailure: (String) -> Unit
    )

    fun loadUpComingMovie(
        onSuccess: (upComingMovie: UpComingMovieVO) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getUpComingMovie(): LiveData<UpComingMovieVO>

    fun loadMoreUpComingMovie(
        url: String,
        page: Long,
        onSuccess: (upComingMovie: UpComingMovieVO)->Unit,
        onFailure: (String) -> Unit
    )

    fun loadMovieDetail(
        movieId: Long,
        onSuccess: (movieDetailVO: MovieDetailVO) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getMovieDetailById(movieId: Long): LiveData<MovieDetailVO>

    fun loadMovieVideo(
        movieId: Long,
        onSuccess: (movieVideoVO: MovieVideoVO) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getMovieVideo(movieId: Long): LiveData<MovieVideoVO>

    fun loadSearchMovie(
        search: String,
        onSuccess: (searchMovieVO: SearchMovieVO) -> Unit,
        onFailure: (String) -> Unit
    )

    fun loadMoreSearchMovie(
        url: String,
        search: String,
        page: Long,
        onSuccess: (searchMovieVO: SearchMovieVO) -> Unit,
        onFailure: (String) -> Unit
    )

}