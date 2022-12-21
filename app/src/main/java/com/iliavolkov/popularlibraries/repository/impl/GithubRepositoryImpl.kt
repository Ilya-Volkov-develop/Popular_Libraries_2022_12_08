package com.iliavolkov.popularlibraries.repository.impl

import com.iliavolkov.popularlibraries.model.GithubUser
import com.iliavolkov.popularlibraries.repository.GithubRepository

class GithubRepositoryImpl: GithubRepository {

    private val repositories = listOf(
        GithubUser("Ilia"),
        GithubUser("Vika"),
        GithubUser("Mixa"),
        GithubUser("Lev"),
        GithubUser("Vlad"),
        GithubUser("Viktor"),
    )

    override fun getUsers(): List<GithubUser> {
        return repositories
    }

}