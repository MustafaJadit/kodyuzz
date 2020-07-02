package com.kodyuzz.daggerproject.di.module

import android.app.Application
import android.content.Context
import com.kodyuzz.daggerproject.qualifier.ApplicationContext
import com.kodyuzz.daggerproject.qualifier.DBName
import com.kodyuzz.daggerproject.qualifier.URL_
import dagger.Module
import dagger.Provides


@Module
class ApplicationModule(private val application: Application) {
    @get:Provides
    val dBVersion: Int
        get() = 1

    @get:Provides
    @get:DBName
    val dBName: String
        get() = "db1"

    @get:Provides
    @get:URL_
    val url: String
        get() = "url"

    @get:Provides
    @get:ApplicationContext
    val context: Context
        get() = application

}