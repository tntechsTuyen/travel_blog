package com.travel.app.retrofit;

import com.travel.app.common.response.ApiResponse;
import com.travel.app.data.model.Travel;
import com.travel.app.data.model.User;

import java.util.*;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {

    @GET("test/user.json")
    Call<List<User>> getUser();

    @GET("api/travel/ads")
    Call<ApiResponse<List<Travel>>> getTravelAds();
}
