package dev.hmyh.hmyhassignmentthree.network

import dev.hmyh.hmyhassignmentthree.data.vos.*
import dev.hmyh.hmyhassignmentthree.utils.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HmyhAssignmentThreeApi {

    @GET(GET_NOW_PLAYING_MOVIE_LIST)
    fun loadNowPlayingMovieList(
        @Query(PARAM_API_KEY)apiKey: String
    ):Observable<NowPlayingMovieVO>

    @GET(GET_POPULAR_MOVIE_LIST)
    fun loadPopularMovieList(
        @Query(PARAM_API_KEY)apiKey: String
    ):Observable<PopularMovieVO>

    @GET(GET_TOP_RATED_MOVIE)
    fun loadTopRatedMovieList(
        @Query(PARAM_API_KEY)apkKey: String
    ):Observable<TopRatedMovieVO>

    @GET(GET_UP_COMING_MOVIE)
    fun loadUpComingMovieList(
        @Query(PARAM_API_KEY)apiKey: String
    ):Observable<UpComingMovieVO>

    @GET("$GET_MOVIE_DETAIL{movieId}")
    fun loadMovieDetail(
        @Path("movieId")movieId: Long,
        @Query(PARAM_API_KEY)apiKey: String
    ):Observable<MovieDetailVO>

    @GET("$GET_MOVIE_VIDEO{movieId}/videos")
    fun loadMovieVideo(
        @Path("movieId")movieId: Long,
        @Query(PARAM_API_KEY)apiKey: String
    ):Observable<MovieVideoVO>

}