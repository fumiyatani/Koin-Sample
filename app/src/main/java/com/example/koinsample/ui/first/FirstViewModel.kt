package com.example.koinsample.ui.first

import androidx.lifecycle.*
import com.example.koinsample.data.GitHubRepository
import com.example.koinsample.data.entity.Repo
import kotlinx.coroutines.launch

class FirstViewModel(private val repository: GitHubRepository) : ViewModel() {
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