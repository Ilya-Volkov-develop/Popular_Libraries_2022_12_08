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
                presenter.onCounterClick(0)
            }
            btn2.setOnClickListener {
                presenter.onCounterClick(1)
            }
            btn3.setOnClickListener {
                presenter.onCounterClick(2)
            }
        }

    }

    private fun initPresenter() {
        presenter = CountersPresenter(this, CountersModel())
    }

    override fun setText(counterText: String, position: Int) {
        with(binding) {
            when (position) {
                0 -> tvText1.text = counterText
                1 -> tvText2.text = counterText
                2 -> tvText3.text = counterText
            }
        }
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putIntArray("counter", counter.toIntArray())
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        val array = savedInstanceState.getIntArray("counter")
//        counter.let { list ->
//            list.clear()
//            array?.toList()?.let {
//                list.addAll(it)
//            }
//        }
//        initView()
//    }
}