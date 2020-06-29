package com.kodyuzz.daggerproject.util;

import android.content.Context;
import android.widget.Toast;

import com.kodyuzz.daggerproject.qualifier.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

// extra content

@Singleton
public class NetworkHelper {
    // Should be Application Context
    private Context context;

    @Inject
    public NetworkHelper(@ApplicationContext Context context) {
        this.context = context;
    }

    public boolean isNetworkConnected() {
// will check for network connectivity
        Toast.makeText(context, " connected", Toast.LENGTH_SHORT).show();
        return false;
    }
}