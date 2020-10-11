package com.example.koinsample.ui.repository_list

import androidx.lifecycle.*
import com.example.koinsample.data.GitHubRepository
import com.example.koinsample.data.entity.Repo
import kotlinx.coroutines.launch

class GitHubRepositoryListViewModel(private val repository: GitHubRepository) : ViewModel() {

    init {
        loadRepositories()
    }

    // MutableLiveDataのコンストラクタの値を設定しないと初回のイベントは発生しないため未設定。
    private val _repositories = MutableLiveData<List<Repo>>()
    val repositories: LiveData<List<Repo>> = _repositories.distinctUntilChanged()

    private fun loadRepositories(userName: String = "fumiyatani") =
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