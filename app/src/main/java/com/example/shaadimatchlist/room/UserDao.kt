package com.example.shaadimatchlist.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM user_info WHERE uuid=:uuid ")
    suspend fun getUser(uuid: String): UserInfo

    @Query("SELECT * FROM user_info")
    fun getAll(): LiveData<List<UserInfo>>

    @Update
    suspend fun updateUser(user: UserInfo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userInfo: UserInfo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<UserInfo>)
}