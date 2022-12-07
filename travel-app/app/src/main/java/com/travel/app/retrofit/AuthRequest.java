package com.travel.app.retrofit;

import com.travel.app.common.response.ApiResponse;
import com.travel.app.data.model.Travel;
import com.travel.app.data.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface AuthRequest {

    @POST("login")
    Call<ApiResponse<String>> login(@Body User user);

    @POST("register")
    Call<ApiResponse<User>> register(@Body User user);

    @GET("api/auth/info")
    Call<ApiResponse<User>> userInfo(@Header("Authorization") String token);

    @POST("api/auth/update")
    Call<ApiResponse<User>> userUpdate(@Header("Authorization") String token, @Body User user);
}
