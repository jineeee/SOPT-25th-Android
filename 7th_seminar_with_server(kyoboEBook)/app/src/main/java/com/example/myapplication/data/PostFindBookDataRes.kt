package com.example.myapplication.data

import com.google.gson.annotations.SerializedName

data class PostFindBookDataRes(
    val success: Boolean,
    val message: String,
    val data: List<BookItem>
)

data class BookItem(
    @SerializedName("bookname")
    val bookName: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("bookcover")
    val bookCover: String,
    @SerializedName("star")
    val star: Float
)