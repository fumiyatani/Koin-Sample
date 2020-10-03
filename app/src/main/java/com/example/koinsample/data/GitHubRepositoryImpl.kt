package com.example.koinsample.data

import com.example.koinsample.data.entity.Repo
import com.example.koinsample.data.service.service
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GitHubRepositoryImpl : GitHubRepository {

    override suspend fun getRepositories(userName: String): List<Repo> = withContext(Dispatchers.IO) {
        service.listReposAsync(userName)
    }

    companion object {
        private var instance: GitHubRepositoryImpl? = null
        fun getInstance(): GitHubRepositoryImpl =
            instance ?: synchronized(this) {
                instance ?: GitHubRepositoryImpl().also {
                    instance = it
                }
            }
    }
}