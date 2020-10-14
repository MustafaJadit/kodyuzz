package com.kodyuzz.tafa.viewmodel

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kodyuzz.tafa.R
import com.mindorks.bootcamp.demo.lifecycle.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.timerData.observe(this, Observer<String> {

        })

        object : I1 {
            override fun i1() {

            }
        }


        Observer<String> { }
    }
}

interface I1 {
    fun i1()
}