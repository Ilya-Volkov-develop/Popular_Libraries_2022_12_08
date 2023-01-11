package com.iliavolkov.popularlibraries

import io.reactivex.rxjava3.core.Observable


private val  data = listOf(1,2,3,4,5,5,5,3,67)

fun main(){
    Observable.fromIterable(data)
        .subscribe(
            {element->
                println(element)
            },
            { error ->
                println(error)
            },
            {
                println("sd")
            }

        )

    Observable.fromCallable{
        val result = old()
        return@fromCallable result
    }.subscribe{
        println(it)
    }
}

fun old(): List<Int> {
    Thread.sleep(3000)
    return listOf(4,6,8)
}
