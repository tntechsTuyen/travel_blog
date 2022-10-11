package com.travel.app.retrofit;

import com.travel.app.common.DataStatic;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRequest {
    private static Retrofit retrofit;

    public static Retrofit instance(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(DataStatic.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
