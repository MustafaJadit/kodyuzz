package com.kodyuzz.daggerproject.ui


import androidx.lifecycle.ViewModel
import com.kodyuzz.daggerproject.model.DatabaseService
import com.kodyuzz.daggerproject.model.NetworkService
import com.kodyuzz.daggerproject.scope.ActivityScope
import javax.inject.Inject

//try to change the singleton to singleton
@ActivityScope
class MainViewModel  @Inject constructor(private val databaseService: DatabaseService, private val networkService: NetworkService) : ViewModel() {


    fun refreshData() {
        databaseService.refresh();
        networkService.refresh();
    }

}
