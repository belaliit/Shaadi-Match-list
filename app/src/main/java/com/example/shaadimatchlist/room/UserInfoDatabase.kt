package com.example.shaadimatchlist.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserInfo::class], version = 1)
abstract class UserInfoDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}