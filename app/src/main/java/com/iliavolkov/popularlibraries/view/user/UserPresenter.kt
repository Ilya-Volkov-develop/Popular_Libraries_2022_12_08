package com.iliavolkov.popularlibraries.view.user

import com.github.terrakok.cicerone.Router
import com.iliavolkov.popularlibraries.App
import com.iliavolkov.popularlibraries.repository.impl.GithubRepositoryImpl
import moxy.MvpPresenter

class UserPresenter:MvpPresenter<UserView>() {

    private val router:Router by lazy { App.instance.router }

    fun onBackPressed():Boolean{
        router.exit()
        return true
    }
}