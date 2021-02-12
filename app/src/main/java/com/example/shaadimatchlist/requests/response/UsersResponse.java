package com.example.shaadimatchlist.requests.response;

import com.example.shaadimatchlist.models.User;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsersResponse {
    @SerializedName("results")
    public List<User> users;
}
