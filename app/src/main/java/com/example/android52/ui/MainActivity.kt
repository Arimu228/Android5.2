package com.example.android52.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater

import com.example.android52.R
import com.example.android52.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()

    }

    private fun initViews() {

    }


}