package dev.hmyh.hmyhassignmentthree.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_movie")
data class PopularMovieVO(

    @PrimaryKey
    var id: Int=1,

    @SerializedName("page")
    var page: Long? = null,

    @SerializedName("results")
    var movieList: MutableList<MovieListVO>?=null,

    @SerializedName("total_pages")
    var totalPage: Long?=null,

    @SerializedName("total_results")
    var totalResults: Long?=null

)
