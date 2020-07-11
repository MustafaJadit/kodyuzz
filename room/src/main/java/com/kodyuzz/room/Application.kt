package com.kodyuzz.room

import android.app.Application
import com.kodyuzz.room.di.component.ApplicationComponent
import com.kodyuzz.room.di.component.DaggerApplicationComponent
import com.kodyuzz.room.di.module.ApplicationModule

class Application : Application() {


    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent=DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this))
                .build()
        applicationComponent.inject(this)
    }
}