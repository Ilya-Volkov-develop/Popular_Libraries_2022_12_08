package com.iliavolkov.popularlibraries

import android.os.Bundle
import com.iliavolkov.popularlibraries.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding


    private val presenter by moxyPresenter { CountersPresenter(CountersModel()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding) {
            btn1.setOnClickListener {
                presenter.onCounterClickOne()
            }
            btn2.setOnClickListener {
                presenter.onCounterClickTwo()
            }
            btn3.setOnClickListener {
                presenter.onCounterClickThird()
            }
        }
    }

    override fun setTextOne(counterText: String) {
        binding.tvText1.text = counterText
    }

    override fun setTextTwo(counterText: String) {
        binding.tvText2.text = counterText
    }

    override fun setTextThird(counterText: String) {
        binding.tvText3.text = counterText
    }
}