package dev.hmyh.hmyhassignmentthree.network.response

import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("code")
    val code: Int = 0,

    @SerializedName("message")
    val message: String = ""
){
    fun isResponseOk() = code in 200..299
}