package com.example.koinsample.data.service

import com.example.koinsample.data.entity.Repo
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("users/{user}/repos")
    suspend fun listReposAsync(@Path("user") user: String): Deferred<List<Repo>>
}