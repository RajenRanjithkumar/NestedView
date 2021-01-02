package com.intern.nestedview.model


import com.google.gson.annotations.SerializedName

data class Reqres(
    @SerializedName("response")
    val response: List<Response>
)