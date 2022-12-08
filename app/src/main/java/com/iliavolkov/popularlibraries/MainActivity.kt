package com.iliavolkov.popularlibraries

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.iliavolkov.popularlibraries.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private lateinit var presenter: CountersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()

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

    private fun initPresenter() {
        presenter = CountersPresenter(this, CountersModel())
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