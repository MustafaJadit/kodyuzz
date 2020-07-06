package com.kodyuzz.tafa.lifecycle

import android.app.Application
import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class TimeToast(application: Application, lifeCycleOwner: LifecycleOwner) : LifecycleObserver {

    var started = false
    private val lifeCycle = lifeCycleOwner.lifecycle


    init {
        lifeCycle.addObserver(this)
    }

    private val timer = object : CountDownTimer(60000, 1000) {
        override fun onFinish() {
            Toast.makeText(application, "onFinish", Toast.LENGTH_SHORT).show()
        }

        override fun onTick(p0: Long) {
            Toast.makeText(application, p0.toString(), Toast.LENGTH_SHORT).show()
        }
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        if (!started) {
            started = true
            timer.start()
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {
        timer.cancel()
    }

}