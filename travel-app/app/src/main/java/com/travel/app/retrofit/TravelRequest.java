package com.travel.app.retrofit;

import com.travel.app.common.response.ApiResponse;
import com.travel.app.data.model.Comment;
import com.travel.app.data.model.Hotel;
import com.travel.app.data.model.Travel;
import com.travel.app.data.model.TravelMeta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TravelRequest {

    @GET("api/travel/list")
    Call<ApiResponse<List<Travel>>> getList(@Query("s") String search);

    @GET("api/travel/ads")
    Call<ApiResponse<List<Travel>>> getAds();

    @GET("api/travel/top")
    Call<ApiResponse<List<Travel>>> getTop();

    @GET("api/auth/travel/hobbies")
    Call<ApiResponse<List<Travel>>> getMyHobbies(@Header("Authorization") String token);

    @GET("api/travel/city/{code}")
    Call<ApiResponse<List<Travel>>> getByCity(@Path("code") Integer code);

    @GET("api/travel/{id}")
    Call<ApiResponse<Travel>> getDetail(@Header("Authorization") String token, @Path("id") Integer id);

    @GET("api/travel/{id}/hotel")
    Call<ApiResponse<List<Hotel>>> getTravelHotel(@Path("id") Integer id);

    @GET("api/travel/{id}/metas")
    Call<ApiResponse<List<TravelMeta>>> getTravelMetas(@Path("id") Integer id);

}
