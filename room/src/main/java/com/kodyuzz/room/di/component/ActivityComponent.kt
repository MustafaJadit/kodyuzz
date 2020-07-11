package com.kodyuzz.room.di.component

import com.kodyuzz.room.ui.MainActivity
import com.kodyuzz.room.di.module.ActivityModule
import com.kodyuzz.room.di.scope.ActivityScope
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)
}