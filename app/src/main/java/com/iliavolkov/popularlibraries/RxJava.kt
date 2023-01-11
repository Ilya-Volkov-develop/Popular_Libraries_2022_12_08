package com.iliavolkov.popularlibraries

import io.reactivex.rxjava3.core.Observable


private val  data = listOf(1,2,3,4,5,5,5,3,67,5)

fun main(){
    Observable.fromIterable(data)
        .filter{ it <= 5} //обыкновенный фильтр
        .skip(3) //пропускает первые 3
        .take(6) //первые 3
        .map{
            it + 2 //изменения со всеми элементами
        }
        .map(::mapItemToList)
        .map {
            it.add(8)
            return@map it
        }
        .distinct() //удаляет повторяющиеся элементы
        .distinctUntilChanged() //удаляет повторяющиеся элементы если они стоят рядом
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
}
private fun mapItemToList(value:Int) = mutableListOf(value, 9)