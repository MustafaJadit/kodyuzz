package com.kodyuzz.daggerproject.di.component

import com.kodyuzz.daggerproject.di.module.ActivityModule
import com.kodyuzz.daggerproject.scope.ActivityScope
import com.kodyuzz.daggerproject.ui.MainActivity
import dagger.Component


@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(activity: MainActivity)
}
