package com.kodyuzz.daggerproject.ui;

import androidx.lifecycle.ViewModel;

import com.kodyuzz.daggerproject.model.DatabaseService;
import com.kodyuzz.daggerproject.model.NetworkService;
import com.kodyuzz.daggerproject.scope.ActivityScope;

import javax.inject.Inject;

//try to change the singleton to singleton
@ActivityScope
public class MainViewModel extends ViewModel {


    private final DatabaseService databaseService;
    private final NetworkService networkService;

    @Inject
    public MainViewModel(DatabaseService databaseService, NetworkService networkService) {
        this.databaseService = databaseService;
        this.networkService = networkService;
    }

    public void refreshData() {
        databaseService.refresh();
        networkService.refresh();
    }

}
