package com.example.koinsample.ui.repository_list

import android.util.Log
import androidx.lifecycle.*
import com.example.koinsample.data.GitHubRepository
import com.example.koinsample.data.entity.Repo
import com.example.koinsample.util.Event
import kotlinx.coroutines.launch

class GitHubRepositoryListViewModel(private val repository: GitHubRepository) : ViewModel() {

    init {
        // TODO ViewModelが再生成されるため再度通信処理が呼ばれてしまうので、再度呼ばれない仕組みを用意する
        loadRepositories()
    }

    // MutableLiveDataのコンストラクタの値を設定しないと初回のイベントは発生しないため未設定。
    private val _repositories = MutableLiveData<List<Repo>>()
    val repositories: LiveData<List<Repo>> = _repositories.distinctUntilChanged()

    private val _url = MutableLiveData<Event<String>>()
    val url: LiveData<Event<String>> = _url

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

    fun navigateRepositoryDetail(url: String) {
        Log.d(GitHubRepositoryListFragment::class.java.simpleName, "navigateRepositoryDetail: ")
        _url.value = Event(url)
    }
}