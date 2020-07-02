package com.kodyuzz.daggerproject.di.component

import com.kodyuzz.daggerproject.di.module.FragmentModule
import com.kodyuzz.daggerproject.scope.FragmentScope
import com.kodyuzz.daggerproject.ui.HomeFragment
import dagger.Component

@FragmentScope
@Component(dependencies = [ApplicationComponent::class], modules = [FragmentModule::class])
interface FragmentComponent {

    fun inject(fragment: HomeFragment);
}
