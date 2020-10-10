package com.example.koinsample.data.service

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private val jsonAdapterFactory = MoshiConverterFactory.create(
    Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
)

private val retrofit = Retrofit.Builder()
    .baseUrl("https://api.github.com/")
    .addConverterFactory(
        jsonAdapterFactory
    ).build()

val service: GitHubService = retrofit.create(GitHubService::class.java)

