package com.iliavolkov.popularlibraries.utils.nav

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.iliavolkov.popularlibraries.view.users.UsersFragment

object UsersScreen: FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UsersFragment.newInstance()
    }
}
