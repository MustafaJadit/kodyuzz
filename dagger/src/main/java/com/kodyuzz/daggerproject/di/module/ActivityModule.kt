package com.kodyuzz.daggerproject.di.module

import android.app.Activity
import android.content.Context
import com.kodyuzz.daggerproject.qualifier.ActivityContext
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    @ActivityContext
    fun activityContext(): Context = activity

}
