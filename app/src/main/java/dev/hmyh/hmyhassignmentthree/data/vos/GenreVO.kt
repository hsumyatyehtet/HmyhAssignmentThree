package dev.hmyh.hmyhassignmentthree.data.vos

import com.google.gson.annotations.SerializedName

data class GenreVO(

    @SerializedName("id")
    var id: Long?=null,

    @SerializedName("name")
    var name: String?=null

)
