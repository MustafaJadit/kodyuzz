package com.kodyuzz.daggerproject.ui

import androidx.lifecycle.ViewModel
import com.kodyuzz.daggerproject.model.DatabaseService
import com.kodyuzz.daggerproject.model.NetworkService
import com.kodyuzz.daggerproject.util.NetworkHelper
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val databaseService: DatabaseService, private val networkService: NetworkService, private val networkHelper: NetworkHelper) : ViewModel() {
    fun updateView() {
        networkHelper.isNetworkConnected
    }

}
