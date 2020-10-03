package com.example.koinsample.ui.first

import androidx.lifecycle.*
import com.example.koinsample.data.ProjectRepository
import com.example.koinsample.data.entity.Repo
import kotlinx.coroutines.launch

class FirstViewModel(private val repository: ProjectRepository) : ViewModel() {
    private val _repositories = MutableLiveData<List<Repo>>()
    val repositories: LiveData<List<Repo>> = _repositories.distinctUntilChanged()

    fun getRepositories(userName: String) =
        viewModelScope.launch {
            runCatching {
                repository.getRepositories(userName)
            }.onSuccess {
                _repositories.postValue(it)
            }.onFailure {
                it.printStackTrace()
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