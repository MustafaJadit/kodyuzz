package com.kodyuzz.mylifecycle

import android.app.Application
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class MyToaster(application: Application, lifecycleOwner: LifecycleOwner) : LifecycleObserver {

    val lifecycle = lifecycleOwner.lifecycle

    init {
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {

    }

}