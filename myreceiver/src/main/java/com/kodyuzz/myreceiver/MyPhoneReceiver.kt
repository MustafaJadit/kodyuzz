package com.kodyuzz.myreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.telephony.TelephonyManager
import android.util.Log


class MyPhoneReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.d(TAG, "onReceive: ")
        val extras: Bundle? = intent.getExtras()
        if (extras != null) {
//            val state = extras.getString(TelephonyManager.EXTRA_STATE)
//            Log.w("MY_DEBUG_TAG", state!!)
//            if (state == TelephonyManager.EXTRA_STATE_RINGING) {
//                val phoneNumber = extras
//                        .getString(TelephonyManager.EXTRA_INCOMING_NUMBER)
//                Log.w("MY_DEBUG_TAG", phoneNumber!!)
//            }
        }
    }

    companion object {
        private const val TAG = "MyPhoneReceiver"
    }

}