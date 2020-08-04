package com.kodyuzz.coroutines

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        GlobalScope.launch(Dispatchers.Main) {
            var userOne = async(Dispatchers.IO) {
                println("userOne on thread: "+Thread.currentThread())
                fetchFirstUser()
            }
            var userTwo = async(Dispatchers.IO) {
                println("userTwo on thread: "+Thread.currentThread())
                fetchSecondUser()
            }
            println(" firstUser ${userOne.await()} secondUseR ${userTwo.await()}")


        }
    }

    private fun fetchSecondUser(): User {
        return User()
    }

    private fun fetchFirstUser(): Any {
        return User()
    }


    private fun showUser() {
        Log.d(TAG, "showUser:  thread: ${Thread.currentThread().name}")
    }

    private fun fetchUser(): User {
        Log.d(TAG, "fetchUser: thread: ${Thread.currentThread().name}")
        return User()
    }

    class User()
    companion object {
        private const val TAG = "MainActivity"
    }
}
