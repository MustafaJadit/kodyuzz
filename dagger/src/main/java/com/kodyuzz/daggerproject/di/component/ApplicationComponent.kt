package com.kodyuzz.daggerproject.di.component

import com.kodyuzz.daggerproject.MyApplication
import com.kodyuzz.daggerproject.di.module.ApplicationModule
import com.kodyuzz.daggerproject.model.DatabaseService
import com.kodyuzz.daggerproject.model.NetworkService
import com.kodyuzz.daggerproject.util.NetworkHelper
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: MyApplication);

    fun getNetworkService(): NetworkService;

    fun getDatabaseService(): DatabaseService;

    fun getNetworkHelper(): NetworkHelper;
}