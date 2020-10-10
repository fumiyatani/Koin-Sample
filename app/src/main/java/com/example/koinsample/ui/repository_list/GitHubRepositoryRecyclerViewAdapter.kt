package com.example.koinsample.ui.repository_list

import android.util.Log
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
        itemGithubRepositoryListBinding.repo = githubRepositoryList[position]
    }

    fun updateList(updateGithubRepositoryList: List<Repo>) {
        githubRepositoryList = updateGithubRepositoryList
        notifyDataSetChanged()
    }

    class ViewHolder(
        binding: ItemGithubRepositoryRecyclerviewRowBinding
    ) : RecyclerView.ViewHolder(binding.root)
}

@BindingAdapter("items")
fun bindItems(view: RecyclerView, repos: List<Repo>?) {
    Log.d("bindItems", "bindItems: repos : $repos")
    repos?.let {
        val adapter: GitHubRepositoryRecyclerViewAdapter = view.adapter as GitHubRepositoryRecyclerViewAdapter
        adapter.updateList(it)
    }
}
