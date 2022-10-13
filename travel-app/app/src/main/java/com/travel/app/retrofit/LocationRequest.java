package com.travel.app.retrofit;

import com.travel.app.common.response.ApiResponse;
import com.travel.app.data.model.Location;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LocationRequest {

    @GET("api/location")
    Call<ApiResponse<List<Location>>> getList();
}
