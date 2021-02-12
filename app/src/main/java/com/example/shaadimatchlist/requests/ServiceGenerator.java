package com.example.shaadimatchlist.requests;

import com.example.shaadimatchlist.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static final Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static final Retrofit retrofit = retrofitBuilder.build();

    private static final UserApi restApi = retrofit.create(UserApi.class);

    public static UserApi getRestApi(){
        return restApi;
    }
}
