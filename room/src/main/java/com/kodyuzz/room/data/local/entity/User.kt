package com.kodyuzz.room.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// annotations keep the name of variables, which is in the annotation params, during compilation
@Entity(tableName = "users")
data class User(

        @PrimaryKey(autoGenerate = true)
        var id: Long = 0,

        // annotations keep the name of variables, which is in the annotation params, during compilation
        @ColumnInfo(name = "name")
        var name: String
)