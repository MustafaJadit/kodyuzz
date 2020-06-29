package com.kodyuzz.daggerproject.model;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import com.kodyuzz.daggerproject.qualifier.ApplicationContext;
import com.kodyuzz.daggerproject.qualifier.URL_;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class NetworkService {
    private static final String TAG = "NetworkService";
    private final String url;
    private Context context;

    @Inject
    public NetworkService(@ApplicationContext Context context, @URL_ String url) {
        this.context = context;
        this.url = url;
    }

    public void refresh() {
        Toast toast = Toast.makeText(context, TAG + " is refreshed", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 100, 0);
//        toast.show();

    }
}
