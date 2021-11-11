package dev.hmyh.hmyhassignmentthree.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie_detail")
data class MovieDetailVO(

    @PrimaryKey
    @SerializedName("id")
    var id: Long?=null,

    @SerializedName("backdrop_path")
    var backDropPath: String?=null,

    @SerializedName("genres")
    var genreList: List<GenreVO>?=null,

    @SerializedName("homepage")
    var homePage: String?=null,

    @SerializedName("overview")
    var overView: String?=null,

    @SerializedName("poster_path")
    var posterPath: String?=null,

    @SerializedName("release_date")
    var releaseDate: String?=null,

    @SerializedName("title")
    var title: String?=null,

    @SerializedName("vote_average")
    var voteAverage: String?=null

)