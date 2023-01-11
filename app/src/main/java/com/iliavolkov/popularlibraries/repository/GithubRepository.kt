package com.iliavolkov.popularlibraries.repository

import com.iliavolkov.popularlibraries.model.GithubUser
import io.reactivex.rxjava3.core.Single

interface GithubRepository {
    fun getUsers(): Single<List<GithubUser>>
}