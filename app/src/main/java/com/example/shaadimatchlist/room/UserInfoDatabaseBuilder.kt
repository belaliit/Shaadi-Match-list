package com.example.shaadimatchlist.room

import android.content.Context
import androidx.room.Room

object UserInfoDatabaseBuilder {
    private var INSTANCE: UserInfoDatabase? = null

    fun getInstance(context: Context): UserInfoDatabase {
        if (INSTANCE == null) {
            synchronized(UserInfoDatabase::class) {
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }

    private fun buildRoomDB(context: Context) =
            Room.databaseBuilder(
                    context.applicationContext,
                    UserInfoDatabase::class.java,
                    "user_info"
            ).build()
}