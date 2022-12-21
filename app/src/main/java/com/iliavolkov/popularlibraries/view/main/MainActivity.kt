package com.iliavolkov.popularlibraries.view.main

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.iliavolkov.popularlibraries.App
import com.iliavolkov.popularlibraries.R
import com.iliavolkov.popularlibraries.databinding.ActivityMainBinding
import com.iliavolkov.popularlibraries.utils.OnBackPressedListener
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    private val navigator = AppNavigator(this, R.id.container)
    private lateinit var binding: ActivityMainBinding
    private val presenter by moxyPresenter { MainPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigationHolder.removeNavigator()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        return
    }
}