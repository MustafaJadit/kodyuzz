package com.kodyuzz.room.di.module

import android.content.Context
import androidx.room.Room
import com.kodyuzz.room.Application
import com.kodyuzz.room.data.local.DatabaseService
import com.kodyuzz.room.di.qualifier.ApplicationContext
import com.kodyuzz.room.di.qualifier.DatabaseInfo
import com.kodyuzz.room.di.qualifier.NetworkInfo
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private var application: Application) {
    @ApplicationContext
    @Provides
    fun getApplicationContext(): Context = application


    @Provides
    @DatabaseInfo
    fun getDatabaseName(): String = "dummy_db"

    @Provides
    @DatabaseInfo
    fun getDatabaseVersion(): Int = 1

    @Provides
    @NetworkInfo
    fun getApiKey(): String = "SOME_API_KEY"

    @Singleton
    @Provides
    fun getDatabaseService(): DatabaseService = Room.databaseBuilder(
            application, DatabaseService::class.java, "my_db"
    ).build()

    @Provides
    fun getCompositeDisposable(): CompositeDisposable = CompositeDisposable()
}