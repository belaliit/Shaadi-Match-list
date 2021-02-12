package com.example.shaadimatchlist.room

import androidx.lifecycle.LiveData

class DatabaseHelperImpl(private val appDatabase: UserInfoDatabase): DatabaseHelper {
    override fun getUsers(): LiveData<List<UserInfo>> {
        return appDatabase.userDao().getAll()
    }

    override suspend fun insertAll(users: List<UserInfo>) {
        return appDatabase.userDao().insertAll(users)
    }

    override suspend fun getUser(uuid: String): UserInfo {
        return appDatabase.userDao().getUser(uuid)
    }

    override suspend fun updateUser(userInfo: UserInfo) {
        appDatabase.userDao().updateUser(userInfo)
    }
}