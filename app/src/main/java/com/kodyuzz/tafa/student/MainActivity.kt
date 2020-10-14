package com.kodyuzz.tafa.student

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    companion object {
        var staticVar1: String = "d"
        val TAG: String = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        println(this@MainActivity)
        var view = TextView(this)
        view.setOnClickListener {
            View.OnClickListener { }
        }

        if (savedInstanceState?.getString("name", "") != "") {
            Log.d(TAG, "onCreate: " + "onSaveInstanceState " + savedInstanceState?.getString("name"))
        }

//        HandlerTimer()

//        threadTimer()

        Toast.makeText( applicationContext,"", Toast.LENGTH_SHORT).show()

        threadTimer()

    }


    private fun threadTimer() {
        var thread = Thread {
            Thread.currentThread().name
            Thread.currentThread().isAlive


        }
        thread.start()
        Log.d(TAG, "threadTimer: thread is ${thread.isAlive}")
        class MyThread : Thread() {
            override fun run() {
                super.run()
                println("MyThread is running")
            }
        }
        MyThread().start()


    }

    private fun HandlerTimer() {
        var post = Handler().post({})

        class MyHandler : Handler() {
            override fun getMessageName(message: Message): String {
                message.what
                message.arg1
                message.obj
                return super.getMessageName(message)
            }

            override fun sendMessageAtTime(msg: Message, uptimeMillis: Long): Boolean {
                return super.sendMessageAtTime(msg, uptimeMillis)
            }

            override fun dispatchMessage(msg: Message) {
                super.dispatchMessage(msg)
            }

            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
            }
        }

        MyHandler().sendEmptyMessage(232)
        Handler().sendEmptyMessageDelayed(23, 100)
        Handler().postDelayed({}, 1222)
        synchronized(this@MainActivity) {

        }

    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("name", "tyler")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }
}