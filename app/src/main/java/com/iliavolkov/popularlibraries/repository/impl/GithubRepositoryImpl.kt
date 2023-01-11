package com.iliavolkov.popularlibraries.repository.impl

import com.iliavolkov.popularlibraries.model.GithubUser
import com.iliavolkov.popularlibraries.repository.GithubRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class GithubRepositoryImpl : GithubRepository {

    private val repositories = listOf(
        GithubUser("Ilia"),
        GithubUser("Vika"),
        GithubUser("Mixa"),
        GithubUser("Lev"),
        GithubUser("Vlad"),
        GithubUser("Viktor"),
    )

    override fun getUsers(): Single<List<GithubUser>> {
        return Single.create {
            it.onSuccess(repositories)
        }
    }
}