package com.example.shaadimatchlist.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.shaadimatchlist.requests.UserApi
import com.example.shaadimatchlist.room.UserDao
import com.example.shaadimatchlist.room.UserInfo
import com.example.shaadimatchlist.room.UserInfoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(private val api: UserApi) : BaseRepository() {
    suspend fun getUsers(result: Int) = safeApiCall {
        api.getUsers(result)
    }
}