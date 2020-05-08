package com.example.week2_homework_final.data

import com.google.gson.annotations.SerializedName

data class GetGitRepoData(
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("updated_at")
    val updateAt:String,
    @SerializedName("language")
    val language: String?
)