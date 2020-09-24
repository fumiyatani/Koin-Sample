package com.example.koinsample.ui.first

import android.util.Log
import androidx.lifecycle.*
import com.example.koinsample.data.ProjectRepository
import com.example.koinsample.data.entity.Repo
import kotlinx.coroutines.launch
import java.lang.Exception

class FirstViewModel(private val repository: ProjectRepository) : ViewModel(){
    private val _repositories = MutableLiveData<List<Repo>>()
    val repositories: LiveData<List<Repo>> = _repositories

    fun getRepositories(userName: String) {
        viewModelScope.launch {
            try {
                val response = repository.getRepositories(userName)
                Log.d("First", "getRepositories: start repository")
                if (response.isSuccessful) {
                    _repositories.postValue(response.body())
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

@Suppress("UNCHECKED_CAST")
class FirstViewModelFactory(private val repository: ProjectRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FirstViewModel::class.java)) {
            return FirstViewModel(repository) as T
        }
        throw IllegalArgumentException("FirstViewModel can not cast")
    }
}