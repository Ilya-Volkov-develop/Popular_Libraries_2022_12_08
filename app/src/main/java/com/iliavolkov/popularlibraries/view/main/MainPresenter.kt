package com.iliavolkov.popularlibraries.view.main

import com.github.terrakok.cicerone.Router
import com.iliavolkov.popularlibraries.App
import com.iliavolkov.popularlibraries.repository.impl.GithubRepositoryImpl
import com.iliavolkov.popularlibraries.utils.nav.UsersScreen
import moxy.MvpPresenter

class MainPresenter:MvpPresenter<MainView>() {

    private val router: Router by lazy { App.instance.router }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(UsersScreen)
    }

    fun onBackPressed() {
        router.exit()
    }
}