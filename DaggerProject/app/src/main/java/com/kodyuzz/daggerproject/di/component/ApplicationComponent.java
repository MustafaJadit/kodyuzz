package com.kodyuzz.daggerproject.di.component;

import com.kodyuzz.daggerproject.MyApplication;
import com.kodyuzz.daggerproject.di.module.ApplicationModule;
import com.kodyuzz.daggerproject.model.DatabaseService;
import com.kodyuzz.daggerproject.model.NetworkService;
import com.kodyuzz.daggerproject.util.NetworkHelper;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(MyApplication application);

    NetworkService getNetworkService();

    DatabaseService getDatabaseService();

    NetworkHelper getNetworkHelper();
}
