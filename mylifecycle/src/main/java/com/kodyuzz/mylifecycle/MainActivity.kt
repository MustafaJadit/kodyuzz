package com.kodyuzz.mylifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    lateinit var myToaster: MyToaster

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myToaster = MyToaster(application, this)
    }
}
