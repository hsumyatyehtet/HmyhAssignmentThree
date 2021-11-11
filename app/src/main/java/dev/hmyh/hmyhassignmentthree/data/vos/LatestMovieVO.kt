package dev.hmyh.hmyhassignmentthree.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "latest_movie")
data class LatestMovieVO(

    @PrimaryKey
    @SerializedName("id")
    var id: Long?=null,

    @SerializedName("imdb_id")
    var imdbId: String?=null,

    @SerializedName("poster_path")
    var posterPath: String?=null,

    @SerializedName("title")
    var title: String?=null,

    @SerializedName("backdrop_path")
    var backDropPath: String?=null
)