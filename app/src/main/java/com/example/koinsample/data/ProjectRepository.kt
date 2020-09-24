package com.example.koinsample.data

import android.util.Log
import com.example.koinsample.data.entity.Repo
import com.example.koinsample.data.service.service
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProjectRepository {

    suspend fun getRepositories(userName: String): List<Repo> = withContext(Dispatchers.IO) {
        Log.d("TAG", "getRepositories: 通信開始 $coroutineContext")
        val response = service.listReposAsync(userName)
        Log.d("TAG", "getRepositories: 通信終了 $coroutineContext")
        response
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