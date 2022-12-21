package com.iliavolkov.popularlibraries.view.users

import com.iliavolkov.popularlibraries.model.GithubUser

interface OnItemClickListener {
    fun onItemClick(user:GithubUser)
}