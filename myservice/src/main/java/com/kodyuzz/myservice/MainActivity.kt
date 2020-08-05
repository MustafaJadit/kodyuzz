package com.kodyuzz.myservice

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity(), ServiceConnection {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, MyService::class.java)
//        startService(intent)


//        bindService(intent,this, Context.BIND_AUTO_CREATE)
//        unbindService(this)


        ContextCompat.startForegroundService(this, intent)


        Thread{
            Thread.sleep(1000)
            stopService(Intent(this, MyService::class.java))
        }.start()
    }

    override fun onServiceDisconnected(p0: ComponentName?) {

    }

    override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
    }
}