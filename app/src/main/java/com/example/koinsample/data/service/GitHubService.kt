package com.example.koinsample.data.service

import com.example.koinsample.data.entity.Repo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("users/{user}/repos")
    suspend fun listRepos(@Path("user") user: String): Response<List<Repo>>
}