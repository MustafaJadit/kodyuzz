package com.kodyuzz.daggerproject.di.module;

import android.app.Activity;
import android.content.Context;

import com.kodyuzz.daggerproject.qualifier.ActivityContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }


//    @Provides
//    public MainViewModel getMainViewModel(DatabaseService databaseService, NetworkService networkService) {
//        return new MainViewModel(databaseService, networkService);
//    }

    @ActivityContext
    @Provides
    public Context getActivityContext() {
        return activity;
    }

}
