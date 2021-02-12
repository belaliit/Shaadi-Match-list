package com.example.shaadimatchlist.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shaadimatchlist.requests.UserApi
import com.example.shaadimatchlist.room.DatabaseHelper
import com.example.shaadimatchlist.viewmodels.UserListViewModel

class ViewModelFactory(private val apiHelper: UserApi, private val dbHelper: DatabaseHelper): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserListViewModel::class.java)) {
            return UserListViewModel(apiHelper, dbHelper) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}