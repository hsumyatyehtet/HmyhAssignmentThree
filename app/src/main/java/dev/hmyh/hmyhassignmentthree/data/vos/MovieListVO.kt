package dev.hmyh.hmyhassignmentthree.data.vos

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//@Entity(tableName = "movie_list",indices = [Index(value = ["id"])])
data class MovieListVO(

    @PrimaryKey
    @SerializedName("id")
    var id: Long? = null,

    @SerializedName("original_title")
    var originalTitle: String?=null,

    @SerializedName("overview")
    var overView: String?=null,

    @SerializedName("popularity")
    var popularity: Float?=null,

    @SerializedName("poster_path")
    var posterPath: String?=null,

    @SerializedName("title")
    var title: String?=null,

    @SerializedName("release_date")
    var releaseDate: String?=null,

    @SerializedName("vote_count")
    var voteCount: Long?=null
)