package com.travel.app.retrofit;

import com.travel.app.common.response.ApiResponse;
import com.travel.app.data.model.Hotel;
import com.travel.app.data.model.HotelMeta;
import com.travel.app.data.model.PostUser;
import com.travel.app.data.model.Tag;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SettingRequest {

    @GET("api/setting/tag/list")
    Call<ApiResponse<List<Tag>>> getTagList(@Header("Authorization") String token);

    @POST("api/setting/tag/update")
    Call<ApiResponse<Boolean>> postTagUpdate(@Header("Authorization") String token, @Body List<Integer> idTags);
}
