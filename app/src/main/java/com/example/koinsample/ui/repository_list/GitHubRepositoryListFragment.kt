package com.example.koinsample.ui.repository_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.koinsample.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class GitHubRepositoryListFragment : Fragment() {

    private val firstViewModel: GitHubRepositoryListViewModel by viewModel()

    private lateinit var githubRepositoryRecyclerView: RecyclerView

    private val githubRepositoryRecyclerViewAdapter: GitHubRepositoryRecyclerViewAdapter =
        GitHubRepositoryRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_github_repository_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        githubRepositoryRecyclerView = view.findViewById(R.id.github_repository_recyclerview)
        githubRepositoryRecyclerView.apply {
            adapter = githubRepositoryRecyclerViewAdapter
        }

        firstViewModel.getRepositories("fumiyatani")
    }

    override fun onResume() {
        super.onResume()
        firstViewModel.repositories.observe(viewLifecycleOwner) { repoList ->
            githubRepositoryRecyclerViewAdapter.setGithubRepositoryList(repoList)
        }
    }
}