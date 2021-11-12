package dev.hmyh.hmyhassignmentthree.data.vos

import com.google.gson.annotations.SerializedName

data class ProductionCountryVO(

    @SerializedName("iso_3166_1")
    var iso: String? = null,

    @SerializedName("name")
    var name: String? = null

)