package com.example.shaadimatchlist.room

import androidx.lifecycle.LiveData

interface DatabaseHelper {
    fun getUsers(): LiveData<List<UserInfo>>
    suspend fun insertAll(users: List<UserInfo>)
    suspend fun getUser(uuid: String): UserInfo
    suspend fun updateUser(userInfo: UserInfo)
}