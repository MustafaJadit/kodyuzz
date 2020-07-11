package com.kodyuzz.room.di.qualifier

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.SOURCE)
annotation class ApplicationContext

@Retention(AnnotationRetention.SOURCE)
@Qualifier
annotation class ActivityContext

@Retention(AnnotationRetention.SOURCE)
@Qualifier
annotation class DatabaseInfo


@Retention(AnnotationRetention.SOURCE)
@Qualifier
annotation class NetworkInfo