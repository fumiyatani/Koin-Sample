package com.example.koinsample.ui.repository_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.koinsample.R
import com.example.koinsample.data.entity.Repo

class GitHubRepositoryRecyclerViewAdapter : RecyclerView.Adapter<GithubRepositoryRecyclerViewHolder>() {

    private var githubRepositoryList = listOf<Repo>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GithubRepositoryRecyclerViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(
            R.layout.item_github_repository_recyclerview_row, parent, false)
        return GithubRepositoryRecyclerViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return githubRepositoryList.size
    }

    override fun onBindViewHolder(holder: GithubRepositoryRecyclerViewHolder, position: Int) {
        holder.bindData(githubRepositoryList[position])
    }

    fun setGithubRepositoryList(updateGithubRepositoryList: List<Repo>) {
        githubRepositoryList = updateGithubRepositoryList
        notifyDataSetChanged()
    }
}

