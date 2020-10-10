package com.example.koinsample.ui.repository_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.koinsample.R
import com.example.koinsample.databinding.FragmentGithubRepositoryListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GitHubRepositoryListFragment : Fragment() {

    private val githubRepositoryListViewModel: GitHubRepositoryListViewModel by viewModel()

    private lateinit var fragmentGithubRepositoryListBinding: FragmentGithubRepositoryListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentGithubRepositoryListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_github_repository_list, container, false
        )
        return fragmentGithubRepositoryListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentGithubRepositoryListBinding.lifecycleOwner = viewLifecycleOwner
        fragmentGithubRepositoryListBinding.viewModel = githubRepositoryListViewModel
        fragmentGithubRepositoryListBinding.adapter =
            GitHubRepositoryRecyclerViewAdapter(viewLifecycleOwner)

        // 購読開始
        subscribeToViewModel()
    }

    private fun subscribeToViewModel() {
        githubRepositoryListViewModel.getRepositories("fumiyatani")
    }
}