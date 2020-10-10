package com.example.koinsample.ui.repository_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.koinsample.R
import com.example.koinsample.data.entity.Repo
import com.example.koinsample.databinding.ItemGithubRepositoryRecyclerviewRowBinding

class GitHubRepositoryRecyclerViewAdapter(
    private val viewModel: GitHubRepositoryListViewModel,
    private val lifecycleOwner: LifecycleOwner
) : RecyclerView.Adapter<GitHubRepositoryRecyclerViewAdapter.ViewHolder>() {

    private lateinit var itemGithubRepositoryListBinding: ItemGithubRepositoryRecyclerviewRowBinding
    private var githubRepositoryList: List<Repo> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        itemGithubRepositoryListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_github_repository_recyclerview_row,
            parent,
            false
        )
        itemGithubRepositoryListBinding.lifecycleOwner = lifecycleOwner
        return ViewHolder(itemGithubRepositoryListBinding)
    }

    override fun getItemCount(): Int = githubRepositoryList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repo = githubRepositoryList[position]
        itemGithubRepositoryListBinding.repo = repo
        // Two-WayのBindingを目指していたが、イベントまでxmlに記述すると分かりづらくなりそうなため
        // onClickListenerのイベントはコード上で行うようにし、
        // イベントはViewModelのメソッドに流し込むようにした。
        itemGithubRepositoryListBinding.root.setOnClickListener {
            viewModel.navigateRepositoryDetail(
                repo.url
            )
        }
    }

    fun updateList(updateGithubRepositoryList: List<Repo>) {
        githubRepositoryList = updateGithubRepositoryList
        notifyDataSetChanged()
    }

    class ViewHolder(
        binding: ItemGithubRepositoryRecyclerviewRowBinding
    ) : RecyclerView.ViewHolder(binding.root)
}

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, adapter: GitHubRepositoryRecyclerViewAdapter) {
    view.adapter = adapter
}

@BindingAdapter("items")
fun bindItems(view: RecyclerView, repos: List<Repo>?) {
    repos?.let {
        val adapter: GitHubRepositoryRecyclerViewAdapter =
            view.adapter as GitHubRepositoryRecyclerViewAdapter
        adapter.updateList(it)
    }
}
