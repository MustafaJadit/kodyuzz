package com.kodyuzz.daggerproject.model

import android.content.Context
import com.kodyuzz.daggerproject.qualifier.ApplicationContext
import com.kodyuzz.daggerproject.qualifier.DBName
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DatabaseService @Inject constructor(@ApplicationContext private val context: Context, private val dbVersion: Int, @DBName private val dbName: String) {
    fun refresh() {
//        Toast.makeText(context, TAG + " is refreshed", Toast.LENGTH_LONG).show();
    }

    companion object {
        private const val TAG = "DatabaseService"
    }

}
