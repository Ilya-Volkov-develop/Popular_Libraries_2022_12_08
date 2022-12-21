package com.iliavolkov.popularlibraries.repository

import com.iliavolkov.popularlibraries.model.GithubUser

interface GithubRepository {
    fun getUsers():List<GithubUser>
}