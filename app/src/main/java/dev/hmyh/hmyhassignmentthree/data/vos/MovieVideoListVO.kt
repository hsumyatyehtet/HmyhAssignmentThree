package dev.hmyh.hmyhassignmentthree.data.vos

import com.google.gson.annotations.SerializedName

data class MovieVideoListVO(

    @SerializedName("name")
    var name: String?=null,

    @SerializedName("key")
    var key: String?=null,

    @SerializedName("site")
    var site: String?=null,

    @SerializedName("size")
    var size: Long?=null,

    @SerializedName("type")
    var type: String?=null,

    @SerializedName("id")
    var id: String?=null

)