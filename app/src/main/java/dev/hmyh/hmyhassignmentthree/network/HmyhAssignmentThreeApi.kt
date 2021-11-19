package dev.hmyh.hmyhassignmentthree.network

import dev.hmyh.hmyhassignmentthree.data.vos.*
import dev.hmyh.hmyhassignmentthree.network.response.MoreDataResponse
import dev.hmyh.hmyhassignmentthree.utils.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface HmyhAssignmentThreeApi {

    @GET(GET_NOW_PLAYING_MOVIE_LIST)
    fun loadNowPlayingMovieList(
        @Query(PARAM_API_KEY)apiKey: String
    ):Observable<NowPlayingMovieVO>

    @GET
    fun loadMoreNowPlayingMovieList(
        @Url url: String,
        @Query(PARAM_API_KEY)apiKey: String,
        @Query(PARAM_PAGE)page: Long
    ):Observable<NowPlayingMovieVO>

    @GET(GET_POPULAR_MOVIE_LIST)
    fun loadPopularMovieList(
        @Query(PARAM_API_KEY)apiKey: String
    ):Observable<PopularMovieVO>

    @GET
    fun loadMorePopularMovieList(
        @Url url: String,
        @Query(PARAM_API_KEY)apiKey: String,
        @Query(PARAM_PAGE)page: Long
    ):Observable<PopularMovieVO>

    @GET(GET_TOP_RATED_MOVIE)
    fun loadTopRatedMovieList(
        @Query(PARAM_API_KEY)apkKey: String
    ):Observable<TopRatedMovieVO>

    @GET
    fun loadMoreTopRatedMovieList(
        @Url url: String,
        @Query(PARAM_API_KEY)apiKey: String,
        @Query(PARAM_PAGE)page: Long
    ):Observable<TopRatedMovieVO>

    @GET(GET_UP_COMING_MOVIE)
    fun loadUpComingMovieList(
        @Query(PARAM_API_KEY)apiKey: String
    ):Observable<UpComingMovieVO>

    @GET
    fun loadMoreUpComingMovieList(
        @Url url: String,
        @Query(PARAM_API_KEY)apiKey: String,
        @Query(PARAM_PAGE)page: Long
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

    @GET(GET_SEARCH_MOVIE)
    fun loadSearchMovie(
        @Query(PARAM_API_KEY)apiKey: String,
        @Query(PARAM_QUERY)query: String
    ):Observable<SearchMovieVO>

    @GET
    fun loadMoreSearchMovie(
        @Url url: String,
        @Query(PARAM_API_KEY)apkKey: String,
        @Query(PARAM_QUERY)query: String,
        @Query(PARAM_PAGE)page: Long
    ):Observable<SearchMovieVO>

}