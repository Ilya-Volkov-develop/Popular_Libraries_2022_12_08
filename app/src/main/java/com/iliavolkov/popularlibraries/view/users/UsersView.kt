package com.iliavolkov.popularlibraries.view.users

import com.iliavolkov.popularlibraries.model.GithubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UsersView: MvpView {

    fun initList(list:List<GithubUser>)
    fun showLoading()
    fun hideLoading()
}