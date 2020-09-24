package com.example.koinsample.data

import com.example.koinsample.data.service.service

class ProjectRepository {

    suspend fun getRepositories(userName: String) = service.listRepos(userName)

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