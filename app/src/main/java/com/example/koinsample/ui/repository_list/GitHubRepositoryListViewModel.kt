package com.example.koinsample.ui.repository_list

import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.*
import com.example.koinsample.data.GitHubRepository
import com.example.koinsample.data.entity.Repo
import kotlinx.coroutines.launch

class GitHubRepositoryListViewModel(private val repository: GitHubRepository) : ViewModel() {
    private val _repositories = MutableLiveData<List<Repo>>()
    val repositories: LiveData<List<Repo>> = _repositories.distinctUntilChanged()

    fun getRepositories(userName: String) =
        viewModelScope.launch {
            runCatching {
                repository.getRepositories(userName)
            }.onSuccess {
                Log.d("getRepositories", "getRepositories: List<Repo> : $it")
                _repositories.postValue(it)
            }.onFailure {
                it.printStackTrace()
            }
        }
}