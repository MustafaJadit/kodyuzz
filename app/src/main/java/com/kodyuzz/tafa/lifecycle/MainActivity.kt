package com.kodyuzz.tafa.lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var myToast: TimeToast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myToast = TimeToast(application, this)
    }

//    override fun onStop() {
//        super.onStop()
//        myToast.stop()
//
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//    }
}