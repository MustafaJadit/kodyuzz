package com.kodyuzz.daggerproject.model;

import android.content.Context;
import android.widget.Toast;

import com.kodyuzz.daggerproject.qualifier.ApplicationContext;
import com.kodyuzz.daggerproject.qualifier.DBName;

import javax.inject.Inject;
import javax.inject.Singleton;

//try to change the single as customized scope
@Singleton
public class DatabaseService {
    private static final String TAG = "DatabaseService";

    private final String dbName;
    private Context context;
    private int dbVersion;

    @Inject
    public DatabaseService(@ApplicationContext Context context, int dbVersion, @DBName String dbName) {
        this.context = context;
        this.dbVersion = dbVersion;
        this.dbName = dbName;
    }

    public void refresh() {
//        Toast.makeText(context, TAG + " is refreshed", Toast.LENGTH_LONG).show();
    }
}
