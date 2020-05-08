package com.example.myapplication.data

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class PostHashtagRes(
    val success: Boolean,
    val message: String,
    val data: Hashtag
)

data class Hashtag(
    @SerializedName("image")
    val hashtagImage: String,
    @SerializedName("main_keyword")
    val mainKeyword: String,
    @SerializedName("keywords")
    val keyword: String
)