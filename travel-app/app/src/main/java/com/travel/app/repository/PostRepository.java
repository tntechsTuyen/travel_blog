package com.travel.app.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.travel.app.common.response.ApiResponse;
import com.travel.app.common.utils.RestUtils;
import com.travel.app.data.model.Comment;
import com.travel.app.data.model.Location;
import com.travel.app.retrofit.LocationRequest;
import com.travel.app.retrofit.PostRequest;
import com.travel.app.retrofit.RetrofitRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository {
    private final PostRequest postRequest;

    public PostRepository(){
        postRequest = RetrofitRequest.instance().create(PostRequest.class);
    }

    public LiveData<ApiResponse<List<Comment>>> getComments(Integer id){
        MutableLiveData<ApiResponse<List<Comment>>> data = new MutableLiveData<>();
        postRequest.getComments(id).enqueue(new Callback<ApiResponse<List<Comment>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Comment>>> call, Response<ApiResponse<List<Comment>>> response) {
                data.setValue(RestUtils.get(response));
            }

            @Override
            public void onFailure(Call<ApiResponse<List<Comment>>> call, Throwable t) {

            }
        });
        return data;
    }

    public LiveData<ApiResponse<Comment>> postComment(String token, Comment comment){
        MutableLiveData<ApiResponse<Comment>> data = new MutableLiveData<>();
        token = (token != null & token.trim().length() > 0) ? "Bearer ".concat(token).replaceAll("\"", "") : "";
        postRequest.postComment(token, comment).enqueue(new Callback<ApiResponse<Comment>>() {
            @Override
            public void onResponse(Call<ApiResponse<Comment>> call, Response<ApiResponse<Comment>> response) {
                data.setValue(RestUtils.get(response));
            }

            @Override
            public void onFailure(Call<ApiResponse<Comment>> call, Throwable t) {

            }
        });
        return data;
    }


}
