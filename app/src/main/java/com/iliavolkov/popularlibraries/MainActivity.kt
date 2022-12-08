package com.iliavolkov.popularlibraries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iliavolkov.popularlibraries.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)


    }
}