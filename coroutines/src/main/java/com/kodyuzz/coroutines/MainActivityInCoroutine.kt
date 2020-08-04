package com.kodyuzz.coroutines

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivityInCoroutine : AppCompatActivity(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job + handler

    lateinit var job: Job

    companion object {
        private const val TAG = "MainActivityInCoroutine"
    }

    var handler = CoroutineExceptionHandler { _, exception ->
        println(exception.message)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = Job()

        launch {
            try {
                var userOne = async(Dispatchers.IO) { fetchFirstUser() }
                var userTwo = async(Dispatchers.IO) { fetchSecondUser() }
            } catch (exception: Exception) {
                Log.d(TAG, "onCreate: ${exception}")
            }

        }

        /////////////////////////////////////////////////

        launch(Dispatchers.Main + handler) {
            var userOne = async(Dispatchers.IO) { fetchFirstUser() }
            var userTwo = async(Dispatchers.IO) { fetchSecondUser() }
        }

        /////////////////////////////////////////////////
//        since alrady set handler in activityCoroutineScope, no need to include handler, dispatcher
        launch {
            var userOne = async(Dispatchers.IO) { fetchFirstUser() }
            var userTwo = async(Dispatchers.IO) { fetchSecondUser() }
        }

        /////////////////////////////////////////////////
        launch {
            try {
                coroutineScope {
                    var userOne = async(Dispatchers.IO) { fetchFirstUser() }
                    userOne.await()
                    var userTwo = async(Dispatchers.IO) { fetchSecondUser() }
                    userTwo.await()
                }
            } catch (e: java.lang.Exception) {
                Log.d(TAG, "onCreate: handled")
            }
        }
        /////////////////////////////////////////////////
        launch {
            try {
                supervisorScope {
                    var userOne = async(Dispatchers.IO) { fetchFirstUser() }
                    var userTwo = async(Dispatchers.IO) { fetchSecondUser() }

                    try {
                        userOne.await()
                    } catch (e: java.lang.Exception) {
                        println(e)
                    }
                    try {
                        userTwo.await()
                    } catch (e: java.lang.Exception) {
                        println(e)
                    }
                }
            } catch (e: java.lang.Exception) {
                Log.d(TAG, "onCreate: ${e}")
            }
        }


    }


    private fun fetchSecondUser(): MainActivity.User {
        return MainActivity.User()
    }

    private fun fetchFirstUser(): Any {
        return MainActivity.User()
    }


    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}