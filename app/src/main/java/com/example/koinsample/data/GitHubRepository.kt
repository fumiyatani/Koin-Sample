package com.example.koinsample.data

import com.example.koinsample.data.entity.Repo

interface GitHubRepository {
    suspend fun getRepositories(userName: String): List<Repo>
}