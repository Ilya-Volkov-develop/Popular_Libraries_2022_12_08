package com.iliavolkov.popularlibraries

import moxy.MvpPresenter

class CountersPresenter(private val model: CountersModel):MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        //INIT
    }

    fun onCounterClickOne() {
        viewState.setTextOne(model.next(0).toString())
    }

    fun onCounterClickTwo() {
        viewState.setTextTwo(model.next(1).toString())
    }

    fun onCounterClickThird() {
        viewState.setTextThird(model.next(2).toString())
    }
}