package com.travel.app.retrofit;

import com.travel.app.common.response.ApiResponse;
import com.travel.app.data.model.Comment;
import com.travel.app.data.model.Location;
import com.travel.app.data.model.PostUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PostRequest {

    @GET("api/post/{id_post}/comments")
    Call<ApiResponse<List<Comment>>> getComments(@Path("id_post") Integer id);

    @POST("api/post/comment")
    Call<ApiResponse<Comment>> postComment(@Header("Authorization") String token, @Body Comment comment);

    @GET("api/post/rate")
    Call<ApiResponse<PostUser>> postRate(@Body PostUser postUser);
}
