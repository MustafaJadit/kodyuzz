package com.kodyuzz.daggerproject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kodyuzz.daggerproject.MyApplication
import com.kodyuzz.daggerproject.R
import com.kodyuzz.daggerproject.di.component.DaggerActivityComponent
import com.kodyuzz.daggerproject.di.module.ActivityModule
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerActivityComponent
                .builder()
                .applicationComponent((application as MyApplication).getApplicationComponent())
                .activityModule(ActivityModule(this))
                .build()
                .inject(this)

        viewModel.refreshData()


    }
}