package com.iliavolkov.popularlibraries

class CountersPresenter(private val view: MainView, private val model: CountersModel) {


    fun onCounterClick(position: Int) {
        view.setText(model.next(position).toString(), position)
    }

    //presenter не должен знать R и id
//    fun onCounterClick(id: Int, position: Int) {
//        when (id) {
//            R.id.btn1 -> {
//                val newValue = model.next(position)
//                view.setText(newValue.toString(), position)
//            }
//            R.id.btn2 -> {
//                val newValue = model.next(position)
//                view.setText(newValue.toString(), position)
//            }
//            R.id.btn3 -> {
//                val newValue = model.next(position)
//                view.setText(newValue.toString(), position)
//            }
//        }
//    }
}