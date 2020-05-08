package com.example.week2_homework_final.api

import com.example.week2_homework_final.data.GetFollowerData
import com.example.week2_homework_final.data.GetGitRepoData
import com.example.week2_homework_final.data.GetUserData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("/users/{login}")
    fun getUser(
        @Path("login") login: String
    ): Call<GetUserData>

    @GET("/users/{login}/followers")
    fun getFollowers(
        @Path("login") login: String
    ): Call<List<GetFollowerData>>

    @GET("/users/{login}/repos")
    fun getRepos(
        @Path("login") login: String
    ): Call<List<GetGitRepoData>>
}