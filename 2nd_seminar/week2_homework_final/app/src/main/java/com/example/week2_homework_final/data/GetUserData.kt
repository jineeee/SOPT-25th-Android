package com.example.week2_homework_final.data

import com.google.gson.annotations.SerializedName

data class GetUserData(
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("login")
    val name: String,
    @SerializedName("bio")
    val bio: String
)