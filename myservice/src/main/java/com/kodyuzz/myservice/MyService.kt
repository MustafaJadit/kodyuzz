package com.kodyuzz.myservice

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.util.Log

class MyService : Service() {


    override fun onBind(intent: Intent): IBinder? {
        Log.d(TAG, "onBind: ")
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand: ")

        val intent2 = Intent(this, SecondActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, REQUEST_CODE, intent2, 0)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val notificationChannel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)

            val notification = Notification.Builder(this, CHANNEL_ID)
                    .setContentTitle("title1")
                    .setContentText("text1")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentIntent(pendingIntent)
                    .setExtras(Bundle().apply {
                        putString("k1", "v1")
                        putInt("k2", 2)
                    })
                    .build()
            startForeground(ID, notification)
        }

        Thread {
            Thread.sleep(20000)
            stopSelf()
        }.start()
        return START_NOT_STICKY
    }

    companion object {
        private const val TAG = "MyService"
        const val CHANNEL_ID = "23213"
        const val CHANNEL_NAME = "kjkfd"
        const val REQUEST_CODE = 1
        const val ID = 32
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: ")
        super.onDestroy()
//        stopForeground(true)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(TAG, "onUnbind: ")
        return super.onUnbind(intent)

    }
}
