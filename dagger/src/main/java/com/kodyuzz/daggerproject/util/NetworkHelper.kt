package com.kodyuzz.daggerproject.util

import android.content.Context
import android.widget.Toast
import com.kodyuzz.daggerproject.qualifier.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

// extra content
@Singleton
class NetworkHelper @Inject constructor(// Should be Application Context
        @ApplicationContext private val context: Context) {
    // will check for network connectivity
    val isNetworkConnected: Boolean
        get() {
            // will check for network connectivity
            Toast.makeText(context, " connected", Toast.LENGTH_SHORT).show()
            return false
        }

}