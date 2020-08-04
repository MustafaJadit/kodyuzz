package com.kodyuzz.coroutines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyViewModel : ViewModel() {
    fun fetchAndShowUser() {
        viewModelScope.launch {
            val user = fetchUser()
        }
    }


    suspend fun fetchUser(): MainActivity.User {
        return withContext(Dispatchers.Default) {
            MainActivity.User()
        }
    }

    init {
        fetchAndShowUser()
    }
}