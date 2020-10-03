package com.example.koinsample.data

import com.example.koinsample.data.entity.Repo
import com.example.koinsample.data.service.service
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProjectRepository {

    suspend fun getRepositories(userName: String): List<Repo> = withContext(Dispatchers.IO) {
        service.listReposAsync(userName)
    }

    companion object {
        private var instance: ProjectRepository? = null
        fun getInstance(): ProjectRepository =
            instance ?: synchronized(this) {
                instance ?: ProjectRepository().also {
                    instance = it
                }
            }
    }
}