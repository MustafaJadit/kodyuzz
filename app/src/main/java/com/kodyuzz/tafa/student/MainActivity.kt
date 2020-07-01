package com.kodyuzz.tafa.student

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        var staticVar1: String = "d"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        println(this@MainActivity)
        var view = TextView(this)
        view.setOnClickListener {
            View.OnClickListener { }
        }
    }
}