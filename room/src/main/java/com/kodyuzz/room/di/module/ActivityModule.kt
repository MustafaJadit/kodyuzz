package com.kodyuzz.room.di.module

import android.app.Activity
import android.content.Context
import com.kodyuzz.room.di.qualifier.ActivityContext
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(var activity: Activity) {

    @ActivityContext
    @Provides
    fun getActivityContext(): Context = activity

    
}