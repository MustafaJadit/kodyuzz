package com.kodyuzz.room.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kodyuzz.room.data.local.dao.UserDao
import com.kodyuzz.room.data.local.entity.User

//@Singleton
//class DatabaseService @Inject constructor(
//        @ApplicationContext private val context: Context,
//        @DatabaseInfo private val databaseName: String,
//        @DatabaseInfo private val version: Int
//) {
//    val dummyData: String
//        get() {
//            return "DATABASE_DUMMY_DATA"
//        }
// }


@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class DatabaseService : RoomDatabase() {
    abstract fun userDao(): UserDao
}