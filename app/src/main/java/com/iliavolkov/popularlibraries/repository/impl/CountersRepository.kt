package com.iliavolkov.popularlibraries.repository.impl

class CountersRepository {

    private val counter = mutableListOf(0, 0, 0)

    fun getCurrent(position:Int):Int{
        return counter[position]
    }

    fun next(position: Int):Int{
        return ++counter[position]
    }

    fun  set(position: Int, value:Int){
        counter[position] = value
    }
}