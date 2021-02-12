package com.example.shaadimatchlist.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_info")
data class UserInfo(
        @PrimaryKey(autoGenerate = false) val uuid: String,
        @ColumnInfo(name = "user_name")val username: String,
        @ColumnInfo(name = "first_name")val firstName: String?,
        @ColumnInfo(name = "last_name")val lastName: String?,
        @ColumnInfo(name = "age")val age: Int?,
        @ColumnInfo(name = "city")val city: String?,
        @ColumnInfo(name = "state")var state: String?,
        @ColumnInfo(name = "country")var country: String?,
        @ColumnInfo(name = "image_url")var imageUrl: String?,
        @ColumnInfo(name = "accepted")var isAccepted: Boolean,
        @ColumnInfo(name = "declined")var isDeclined: Boolean) {

    fun onDeclineClicked() {
        if(!isDeclined) {
            isDeclined = true
            if(isAccepted) {
                isAccepted = false
            }
        }
    }

    fun onAcceptClicked() {
        if(!isAccepted) {
            isAccepted = true
            if(isDeclined) {
                isDeclined = false
            }
        }
    }
}