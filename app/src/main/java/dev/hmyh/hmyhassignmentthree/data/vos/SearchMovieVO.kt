package dev.hmyh.hmyhassignmentthree.data.vos

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class SearchMovieVO(

    @PrimaryKey
    var id: Int=1,

    @SerializedName("page")
    var page: Int? = null,

    @SerializedName("results")
    var movieList: MutableList<MovieListVO>?=null,

)