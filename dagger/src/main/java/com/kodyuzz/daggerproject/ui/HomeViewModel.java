package com.kodyuzz.daggerproject.ui;

import androidx.lifecycle.ViewModel;

import com.kodyuzz.daggerproject.model.DatabaseService;
import com.kodyuzz.daggerproject.model.NetworkService;
import com.kodyuzz.daggerproject.util.NetworkHelper;

import javax.inject.Inject;

public class HomeViewModel extends ViewModel {

    private final DatabaseService databaseService;
    private final NetworkHelper networkHelper;
    private final NetworkService networkService;

    @Inject
    public HomeViewModel(DatabaseService databaseService, NetworkService networkService, NetworkHelper networkHelper) {
        this.databaseService = databaseService;
        this.networkHelper = networkHelper;
        this.networkService = networkService;
    }


    void updateView() {
        networkHelper.isNetworkConnected();
    }
}
