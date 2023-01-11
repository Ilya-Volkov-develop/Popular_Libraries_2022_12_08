package com.iliavolkov.popularlibraries

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable


private val  data = listOf(1,2,3,4,5,5,5,3,67)

fun main(){
    val observer = object : Observer<Int>{
        override fun onSubscribe(d: Disposable) = Unit

        override fun onNext(t: Int) {
            println("Okey: $t")
        }

        override fun onError(e: Throwable) {
            println("Error")
        }

        override fun onComplete() {
            println("Finish")
        }
    }

    val observable = Observable.create(){ emitter ->
        try {
            data.forEach { item ->
                emitter.onNext(item)
            }
        } catch (e:Throwable){
            emitter.onError(e)
        }
        emitter.onComplete()
    }

    observable.subscribe(observer)
}