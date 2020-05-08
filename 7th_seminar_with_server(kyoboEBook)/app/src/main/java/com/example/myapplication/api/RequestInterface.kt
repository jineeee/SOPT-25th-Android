package com.example.myapplication.api

import com.example.myapplication.data.GetTasteBookDataRes
import com.example.myapplication.data.PostFindBookDataRes
import com.example.myapplication.data.PostHashtagRes
import retrofit2.Call
import retrofit2.http.*

interface RequestInterface {

    @FormUrlEncoded
    @POST("/home/book")//uri
    fun getFindBookCategory(
        @Field("category")category : String //category에 String 타입 category 값 전달.
    ) : Call<PostFindBookDataRes> //validate해서 받는 데이터의 형식.

    @GET("/home/booklike/{username}")
    fun getTasteBookName(
        @Path("username")username : String
    ) : Call<GetTasteBookDataRes>

    @FormUrlEncoded
    @POST("/home/hashtag")
    fun getHashtag(
        @Field("username")username : String
    ) : Call<PostHashtagRes>

}