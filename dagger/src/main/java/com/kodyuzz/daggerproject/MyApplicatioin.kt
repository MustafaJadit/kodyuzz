package com.kodyuzz.daggerproject


import android.app.Application
import com.kodyuzz.daggerproject.di.component.ApplicationComponent
import com.kodyuzz.daggerproject.di.component.DaggerApplicationComponent
import com.kodyuzz.daggerproject.di.module.ApplicationModule
import com.kodyuzz.daggerproject.model.DatabaseService
import com.kodyuzz.daggerproject.model.NetworkService
import com.kodyuzz.daggerproject.util.NetworkHelper
import javax.inject.Inject;

class MyApplication : Application() {

    @Inject
    lateinit var networkService: NetworkService;

    @Inject
    lateinit var databaseService: DatabaseService;

    @Inject
    lateinit var networkHelper: NetworkHelper

    private lateinit var applicationComponent: ApplicationComponent;

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
        applicationComponent.inject(this)
    }


    fun getApplicationComponent(): ApplicationComponent = applicationComponent

}
