package com.intern.nestedview.model


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("img_src")
    val imgSrc: String,
    @SerializedName("sub_title")
    val subTitle: String,
    @SerializedName("title")
    val title: String
)