package com.iliavolkov.popularlibraries

class CountersPresenter(private val view: MainView, private val model: CountersModel) {

    fun onCounterClickOne() {
        view.setTextOne(model.next(0).toString())
    }

    fun onCounterClickTwo() {
        view.setTextTwo(model.next(1).toString())
    }

    fun onCounterClickThird() {
        view.setTextThird(model.next(2).toString())
    }
}