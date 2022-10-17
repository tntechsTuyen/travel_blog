package com.travel.app.retrofit;

import com.travel.app.common.response.ApiResponse;
import com.travel.app.data.model.Hotel;
import com.travel.app.data.model.HotelMeta;
import com.travel.app.data.model.Travel;
import com.travel.app.data.model.TravelMeta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface HotelRequest {

    @GET("api/hotel/{id}")
    Call<ApiResponse<Hotel>> getDetail(@Header("Authorization") String token, @Path("id") Integer id);

    @GET("api/hotel/{id}/metas")
    Call<ApiResponse<List<HotelMeta>>> getMetas(@Path("id") Integer id);
}
