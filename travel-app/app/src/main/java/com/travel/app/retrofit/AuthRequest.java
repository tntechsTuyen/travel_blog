package com.travel.app.retrofit;

import com.travel.app.common.response.ApiResponse;
import com.travel.app.data.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthRequest {

    @POST("login")
    Call<ApiResponse<String>> login(@Body User user);

    @POST("register")
    Call<ApiResponse<User>> register(@Body User user);
}
