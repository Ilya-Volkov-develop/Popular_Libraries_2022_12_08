package com.iliavolkov.popularlibraries.view.users

import com.github.terrakok.cicerone.Router
import com.iliavolkov.popularlibraries.App
import com.iliavolkov.popularlibraries.repository.impl.GithubRepositoryImpl
import moxy.MvpPresenter

class UsersPresenter:MvpPresenter<UsersView>() {

    private val githubRepository:GithubRepositoryImpl by lazy { GithubRepositoryImpl() }
    private val router:Router by lazy { App.instance.router }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList(githubRepository.getUsers())
    }

    fun onBackPressed():Boolean{
        router.exit()
        return true
    }


}