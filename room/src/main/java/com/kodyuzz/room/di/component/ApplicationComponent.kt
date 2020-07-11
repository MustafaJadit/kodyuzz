package com.kodyuzz.room.di.component

import com.kodyuzz.room.Application
import com.kodyuzz.room.data.local.DatabaseService
import com.kodyuzz.room.data.remote.NetworkService
import com.kodyuzz.room.di.module.ApplicationModule
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: Application)

    fun getNetworkService(): NetworkService

    fun getDatabaseService(): DatabaseService

    fun getCompositeDisposable(): CompositeDisposable
}