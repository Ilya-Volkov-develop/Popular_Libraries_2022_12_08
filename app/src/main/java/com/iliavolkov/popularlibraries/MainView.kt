package com.iliavolkov.popularlibraries

import com.iliavolkov.popularlibraries.model.GithubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView:MvpView {

    fun initList(list:List<GithubUser>)
}