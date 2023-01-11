package com.iliavolkov.popularlibraries

import io.reactivex.rxjava3.core.*
import java.util.concurrent.TimeUnit
import kotlin.random.Random


private val data = listOf(1, 2, 3, 4, 5, 5, 5, 3, 67, 5)

fun main() {

    val observableName = Observable.just("Jonny", "Ilia", "Vika")
    val observableMail = Observable.just("Jonny@mail.ru", "Ilia@mail.com",)

    Observable.zip(observableName,observableMail){ name, mail ->
        return@zip "$name : $mail"
    }.subscribe{
        println(it)
    }

    observableName
        .flatMap { element ->
            val delay = Random.nextInt(1000)
            return@flatMap Observable.just(element)
                .delay (delay.toLong(),TimeUnit.MILLISECONDS)
        }
//        .observeOn(mainThread) //Переключение на главный поток в android
        .subscribe {
            println(it)
        }

    Single.create {  //возвращает данные и завершается
        it.onSuccess(1)
    }

    Maybe.create{ //Можем вернуть данные а можем завершить поток
        it.onSuccess(1)
        it.onComplete()
    }

    Completable.create{ //Ничего не возвращает
        it.onComplete()
    }

    Flowable.create({//помогает справится с большим потоком
                    it.onNext(1)
    },BackpressureStrategy.DROP)
}