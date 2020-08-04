package com.kodyuzz.tafa.download

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.appcompat.app.AppCompatActivity
import com.kodyuzz.tafa.R

class MainActivity2 : AppCompatActivity(), ServiceConnection {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

//        var intent = Intent(this, MyService::class.java)
//        startService(intent)


//        bindService(intent,this, Context.BIND_AUTO_CREATE)
//        unbindService(this)

//    unbindService(this)
//        var intent1 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))
//
//        startActivity(intent1)

//        stopService(intent)


        startService(Intent(this, MyIntentService::class.java))
    }

    override fun onServiceDisconnected(p0: ComponentName?) {

    }

    override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
    }
}