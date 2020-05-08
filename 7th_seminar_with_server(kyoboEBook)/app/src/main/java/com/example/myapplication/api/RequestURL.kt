package com.example.myapplication.api

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestURL: Application(){
    //private const val BASE_URL = "http://localhost:3000"//API 주소
    private const val BASE_URL = "http://ec2-13-209-62-201.ap-northeast-2.compute.amazonaws.com:3000"//API 주소

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service : RequestInterface = retrofit.create(RequestInterface::class.java)
}