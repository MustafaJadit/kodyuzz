package com.kodyuzz.room.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.kodyuzz.room.data.local.DatabaseService
import com.kodyuzz.room.data.local.entity.User
import com.kodyuzz.room.data.remote.NetworkService
import com.kodyuzz.room.di.scope.ActivityScope
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@ActivityScope
class MainViewmodel @Inject constructor(
        private val compositeDisposable: CompositeDisposable,
        private val databaseService: DatabaseService,
        private val networkService: NetworkService
) {

    companion object {
        private const val TAG = "MainViewmodel"
    }


    val someData: String
        get() = "MainViewmodel"


    val user = MutableLiveData<User>()

    val users = MutableLiveData<List<User>>()

    var allUser: List<User> = emptyList()

    init {
        compositeDisposable.add(
                databaseService.userDao().count()
                        .flatMap {
                            if (it == 0)
                                databaseService.userDao()
                                        .insertMany(User(name = "test1"),
                                                User(name = "test2"),
                                                User(name = "test3"),
                                                User(name = "test4"),
                                                User(name = "test5"),
                                                User(name = "test6")
                                        )
                            else Single.just(0)
                        }
                        .subscribeOn(Schedulers.io())
                        .subscribe({
                            Log.d(TAG, " user exist in the table: $it ")
                        }, {
                            Log.d(TAG, " error  $it ")

                        })
        )


    }


    fun getAllUsers() {
        compositeDisposable.add(
                databaseService.userDao()
                        .getAllUsers()
                        .subscribeOn(Schedulers.io())
                        .subscribe({
                            allUser = it
                            users.postValue(it)
                        }, {
                            Log.d(TAG, "getAllUsers: $it")
                        })
        )
    }

    fun deleteUsers() {
        if (allUser.isNotEmpty())
            compositeDisposable.add(
                    databaseService.userDao()
                            .delete(allUser[0])
                            .flatMap {
                                databaseService.userDao()
                                        .getAllUsers()
                            }
                            .subscribeOn(Schedulers.io())
                            .subscribe({
                                allUser = it
                                users.postValue(it)
                            }, {
                                Log.d(TAG, "getAllUsers: $it")
                            })
            )
    }

    fun onDestroy() {
        compositeDisposable.dispose()
    }

}