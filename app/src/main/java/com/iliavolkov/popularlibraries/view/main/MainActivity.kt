package com.iliavolkov.popularlibraries.view.main

import android.os.Bundle
import com.iliavolkov.popularlibraries.CountersPresenter
import com.iliavolkov.popularlibraries.MainView
import com.iliavolkov.popularlibraries.databinding.ActivityMainBinding
import com.iliavolkov.popularlibraries.model.GithubUser
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private val userAdapter:UserAdapter by lazy { UserAdapter() }
    private val presenter by moxyPresenter { CountersPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvGithubUsers.adapter = userAdapter
    }

    override fun initList(list: List<GithubUser>) {
        userAdapter.setData(list)
    }
}