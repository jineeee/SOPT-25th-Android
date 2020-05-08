package com.example.myapplication.data

import com.google.gson.annotations.SerializedName

data class GetTasteBookDataRes(
    val success: Boolean,
    val message: String,
    val data: List<BookTasteItem>
)

data class BookTasteItem(
    @SerializedName("bookname")
    val bookName: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("bookcover")
    val bookCover: String,
    @SerializedName("star")
    val star: Float
)