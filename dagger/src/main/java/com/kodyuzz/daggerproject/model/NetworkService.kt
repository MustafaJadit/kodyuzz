package com.kodyuzz.daggerproject.model

import android.content.Context
import android.view.Gravity
import android.widget.Toast
import com.kodyuzz.daggerproject.qualifier.ApplicationContext
import com.kodyuzz.daggerproject.qualifier.URL_
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkService @Inject constructor(@ApplicationContext private val context: Context, @URL_ private val url: String) {
    fun refresh() {
        val toast = Toast.makeText(context, "$TAG is refreshed", Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER, 100, 0)
        //        toast.show();
    }

    companion object {
        private const val TAG = "NetworkService"
    }

}
