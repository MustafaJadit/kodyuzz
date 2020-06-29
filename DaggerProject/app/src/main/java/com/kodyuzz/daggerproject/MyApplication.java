package com.kodyuzz.daggerproject;

import android.app.Application;

import com.kodyuzz.daggerproject.di.component.ApplicationComponent;
import com.kodyuzz.daggerproject.di.component.DaggerApplicationComponent;
import com.kodyuzz.daggerproject.di.module.ApplicationModule;
import com.kodyuzz.daggerproject.model.DatabaseService;
import com.kodyuzz.daggerproject.model.NetworkService;

import javax.inject.Inject;

public class MyApplication extends Application {

    @Inject
    NetworkService networkService;

    @Inject
    DatabaseService databaseService;

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);

    }


    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
