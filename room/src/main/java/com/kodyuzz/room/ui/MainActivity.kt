package com.kodyuzz.room.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.kodyuzz.room.Application
import com.kodyuzz.room.R
import com.kodyuzz.room.di.component.DaggerActivityComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        getDependencies()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.users.observe(this, Observer {
            Toast.makeText(applicationContext, it.toString(), Toast.LENGTH_LONG).show()
        })


    }

    override fun onStart() {
        super.onStart()
        viewModel.getAllUsers()
    }

    override fun onStop() {
        super.onStop()
        viewModel.deleteUsers()
    }

    private fun getDependencies() {
        DaggerActivityComponent.builder().applicationComponent((application as Application).applicationComponent)
                .build().inject(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }
}
