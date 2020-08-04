package com.kodyuzz.tafa.download

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder? {
        Log.d(TAG, "onBind: ")
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand: ")
        return super.onStartCommand(intent, flags, startId)
    }

    companion object {
        private const val TAG = "MyService"
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: ")
        super.onDestroy()
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(TAG, "onUnbind: ")
        return super.onUnbind(intent)
        
    }
}
