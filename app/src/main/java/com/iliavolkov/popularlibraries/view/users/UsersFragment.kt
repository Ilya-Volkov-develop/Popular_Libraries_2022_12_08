package com.iliavolkov.popularlibraries.view.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iliavolkov.popularlibraries.databinding.FragmentUsersListBinding
import com.iliavolkov.popularlibraries.model.GithubUser
import com.iliavolkov.popularlibraries.utils.OnBackPressedListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment:MvpAppCompatFragment(),UsersView,OnBackPressedListener {
    private var _binding: FragmentUsersListBinding? = null
    private val binding get() = _binding!!
    private val userAdapter: UsersAdapter by lazy { UsersAdapter() }
    private val presenter by moxyPresenter { UsersPresenter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentUsersListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvGithubUsers.adapter = userAdapter
    }

    override fun initList(list: List<GithubUser>) {
        userAdapter.setData(list)
    }

    companion object {
        @JvmStatic
        fun newInstance() = UsersFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onBackPressed() = presenter.onBackPressed()
}