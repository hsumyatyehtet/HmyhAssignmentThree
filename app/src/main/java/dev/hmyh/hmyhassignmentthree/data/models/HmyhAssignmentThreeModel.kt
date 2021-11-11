package dev.hmyh.hmyhassignmentthree.data.models

import androidx.lifecycle.LiveData
import dev.hmyh.hmyhassignmentthree.data.vos.LatestMovieVO

interface HmyhAssignmentThreeModel {

    fun loadLatestMovie(
        onSuccess: (latestMovie: LatestMovieVO)->Unit,
        onFailure: (String)->Unit
    ): LiveData<LatestMovieVO>

    fun getLatestMovie(): LiveData<LatestMovieVO>

}