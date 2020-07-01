package com.kodyuzz.mylibrary

import android.content.Context
import android.net.ConnectivityManager

object StudentManager {

    fun isNetworkConnceted(context: Context): Boolean {
        var connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.activeNetworkInfo?.isConnected ?: false
    }

}