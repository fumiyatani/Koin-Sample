package com.example.koinsample.ui.repository_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.koinsample.R
import com.example.koinsample.databinding.FragmentGithubRepositoryListBinding
import kotlinx.android.synthetic.main.fragment_github_repository_list.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class GitHubRepositoryListFragment : Fragment() {

    private val githubRepositoryListViewModel: GitHubRepositoryListViewModel by viewModel()
    private lateinit var fragmentGithubRepositoryListBinding: FragmentGithubRepositoryListBinding
    private lateinit var githubRepositoryRecyclerViewAdapter: GitHubRepositoryRecyclerViewAdapter

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
        fragmentGithubRepositoryListBinding.lifecycleOwner = this

        githubRepositoryRecyclerViewAdapter = GitHubRepositoryRecyclerViewAdapter(this)

        with(fragmentGithubRepositoryListBinding.root) {
            githubRepositoryRecyclerview.apply {
                setHasFixedSize(true)
                adapter = githubRepositoryRecyclerViewAdapter
            }
        }
        githubRepositoryListViewModel.getRepositories("fumiyatani")
        observeViewModel()
    }

    private fun observeViewModel() {
        githubRepositoryListViewModel.repositories.observe(viewLifecycleOwner) {
            githubRepositoryRecyclerViewAdapter.updateList(it)
        }
    }
}