package com.mindorks.bootcamp.demo.lifecycle

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val timerData = MutableLiveData<String>()

    private val timer = object : CountDownTimer(60000, 3000) {
        override fun onFinish() {
            timerData.postValue("finish")
        }

        override fun onTick(p0: Long) {
            timerData.postValue("$p0")
        }
    }


    init {
        timer.start()
    }


    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }
}