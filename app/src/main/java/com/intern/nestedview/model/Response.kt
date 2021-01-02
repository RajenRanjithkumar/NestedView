package com.intern.nestedview.model


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("items")
    val items: MutableList<Item>,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String
)