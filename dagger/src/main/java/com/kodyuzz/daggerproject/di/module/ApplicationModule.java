package com.kodyuzz.daggerproject.di.module;

import android.app.Application;
import android.content.Context;

import com.kodyuzz.daggerproject.qualifier.ActivityContext;
import com.kodyuzz.daggerproject.qualifier.ApplicationContext;
import com.kodyuzz.daggerproject.qualifier.DBName;
import com.kodyuzz.daggerproject.qualifier.URL_;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

//    @Provides
//    public DatabaseService getDatabase(int dbVersion, @DBName String dbName) {
//        return new DatabaseService(application, dbVersion, dbName);
//    }
//
//    @Provides
//    public NetworkService getNetworkService(@URL_ String url) {
//        return new NetworkService(application, url);
//    }

    @Provides
    int getDBVersion() {
        return 1;
    }

    @DBName
    @Provides
    String getDBName() {
        return "db1";
    }

    @URL_
    @Provides
    String getUrl() {
        return "url";
    }

    @ApplicationContext
    @Provides
    Context getContext() {
        return application;
    }
}
