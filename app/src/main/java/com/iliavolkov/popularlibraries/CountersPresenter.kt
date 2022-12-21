package com.iliavolkov.popularlibraries

import com.iliavolkov.popularlibraries.repository.impl.GithubRepositoryImpl
import moxy.MvpPresenter

class CountersPresenter:MvpPresenter<MainView>() {

    private val githubRepository:GithubRepositoryImpl by lazy { GithubRepositoryImpl() }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList(githubRepository.getUsers())
    }


}