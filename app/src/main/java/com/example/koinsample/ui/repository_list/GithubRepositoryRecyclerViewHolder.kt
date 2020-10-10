package com.example.koinsample.ui.repository_list

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.koinsample.R
import com.example.koinsample.data.entity.Repo

class GithubRepositoryRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val repositoryTitleTextView: TextView = itemView.findViewById(R.id.repository_title_textview)
    private val repositoryUrlTextView: TextView = itemView.findViewById(R.id.repository_url_textview)

    fun bindData(repo: Repo) {
        repositoryTitleTextView.text = repo.name
        repositoryUrlTextView.text = repo.url
    }
}