package dev.hmyh.hmyhassignmentthree.network

import dev.hmyh.hmyhassignmentthree.data.vos.LatestMovieVO
import dev.hmyh.hmyhassignmentthree.utils.GET_LATEST_MOVIE
import dev.hmyh.hmyhassignmentthree.utils.PARAM_API_KEY
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface HmyhAssignmentThreeApi {

    @GET(GET_LATEST_MOVIE)
    fun loadLatestMovie(
        @Query(PARAM_API_KEY)apkKey: String
    ):Observable<LatestMovieVO>

}