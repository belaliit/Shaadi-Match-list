package com.example.shaadimatchlist.models

import java.util.*

data class Name(var title: String?, var first: String?, var last: String?)
data class Location (var city: String?, var state: String?, var country: String?)
data class Picture (var large: String?)
data class Dob (var date: Date?, var age: Int?)
data class Login(val uuid: String, val username: String)
