package com.example.week2_homework_final.data

import com.google.gson.annotations.SerializedName

data class GetFollowerData(
    @SerializedName("id")
    val id: String,
    @SerializedName("login")
    val login: String
)