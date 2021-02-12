package com.example.shaadimatchlist.requests;

import com.example.shaadimatchlist.requests.response.UsersResponse;
import retrofit2.Call

import retrofit2.http.GET;
import retrofit2.http.Query;

interface UserApi {
    @GET("api/")
    suspend fun getUsers(@Query("results") results: Int): UsersResponse
}
