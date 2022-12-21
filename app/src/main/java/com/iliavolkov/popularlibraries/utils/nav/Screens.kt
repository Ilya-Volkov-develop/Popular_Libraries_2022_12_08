package com.iliavolkov.popularlibraries.utils.nav

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.iliavolkov.popularlibraries.model.GithubUser
import com.iliavolkov.popularlibraries.utils.BUNDLE_KEY_USER_INFO
import com.iliavolkov.popularlibraries.view.user.UserFragment
import com.iliavolkov.popularlibraries.view.users.UsersFragment

object UsersScreen: FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UsersFragment.newInstance()
    }
}
data class UserScreen(val user:GithubUser):FragmentScreen{
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserFragment.newInstance(Bundle().apply {
            putParcelable(BUNDLE_KEY_USER_INFO, user)
        })
    }

}
