package com.kodyuzz.tafa.rxjava

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var mutableLiveData: MutableLiveData<String> = MutableLiveData("s0")

    var countDownTimer = object : CountDownTimer(20000, 1000) {
        override fun onFinish() {
            mutableLiveData.postValue("finished")
        }

        override fun onTick(p0: Long) {
//                Toast.makeText(applicationContext, Thread.currentThread().name, Toast.LENGTH_SHORT).show()
            mutableLiveData.postValue("$p0 left and ${Thread.currentThread().name}")
        }

    }


    init {
        countDownTimer.start()
    }

    override fun onCleared() {
        super.onCleared()
        countDownTimer.cancel()
    }
}