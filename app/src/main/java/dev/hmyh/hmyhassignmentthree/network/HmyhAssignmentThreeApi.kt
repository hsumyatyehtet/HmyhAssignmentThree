package dev.hmyh.hmyhassignmentthree.network

import dev.hmyh.hmyhassignmentthree.data.vos.LatestMovieVO
import dev.hmyh.hmyhassignmentthree.data.vos.NowPlayingMovieVO
import dev.hmyh.hmyhassignmentthree.data.vos.PopularMovieVO
import dev.hmyh.hmyhassignmentthree.data.vos.TopRatedMovieVO
import dev.hmyh.hmyhassignmentthree.utils.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface HmyhAssignmentThreeApi {

    @GET(GET_LATEST_MOVIE)
    fun loadLatestMovie(
        @Query(PARAM_API_KEY)apkKey: String
    ):Observable<LatestMovieVO>

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

}