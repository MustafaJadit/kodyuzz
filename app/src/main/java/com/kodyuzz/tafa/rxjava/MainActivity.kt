package com.kodyuzz.tafa.rxjava

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.kodyuzz.tafa.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        test()
    }

    private fun test() {
        var mutableLiveData: MutableLiveData<String>
    }
}