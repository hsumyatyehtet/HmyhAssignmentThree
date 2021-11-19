package dev.hmyh.hmyhassignmentthree.data.vos

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class SearchMovieVO(

    @PrimaryKey
    var id: Int=1,

    @SerializedName("page")
    var page: Long? = null,

    @SerializedName("results")
    var movieList: MutableList<MovieListVO>?=null,

    @SerializedName("total_pages")
    var totalPages: Long?=null

)