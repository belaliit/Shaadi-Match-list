package com.example.shaadimatchlist.extensions

import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.example.shaadimatchlist.R
import com.example.shaadimatchlist.room.UserInfo

fun UserInfo.formattedName(): String {
    return String.format("%s %s", firstName, lastName)
}

fun UserInfo.agePlusLocation(): String {
    return String.format("%s, %s, %s,", age, state, city)
}

fun AppCompatButton.setTextForAcceptButton(isAccepted: Boolean) {
    text = if (isAccepted) "Accepted" else "Accept"
}

fun AppCompatButton.setTextForDeclineButton(isDeclined: Boolean) {
    text = if (isDeclined) "Declined" else "Decline"
}

fun AppCompatButton.setColorForAcceptButton(isAccepted: Boolean) {
    var color = R.color.accept_dark
    var textColor = R.color.white
    if (!isAccepted) {
        color = R.color.accept_light
        textColor = R.color.text_gray
    }
    setBackgroundColor(ContextCompat.getColor(context, color))
    setTextColor(ContextCompat.getColor(context, textColor))
}

fun AppCompatButton.setColorForDeclineButton(isDeclined: Boolean) {
    var color = R.color.decline_dark
    var textColor = R.color.white
    if (!isDeclined) {
        color = R.color.decline_light
        textColor = R.color.text_gray
    }
    setBackgroundColor(ContextCompat.getColor(context, color))
    setTextColor(ContextCompat.getColor(context, textColor))
}