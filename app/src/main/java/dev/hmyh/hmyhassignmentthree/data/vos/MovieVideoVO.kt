package dev.hmyh.hmyhassignmentthree.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie_video")
data class MovieVideoVO(

    @PrimaryKey
    @SerializedName("id")
    var id: Long? = null,

    @SerializedName("results")
    var movieVideoList: List<MovieVideoListVO>

)
