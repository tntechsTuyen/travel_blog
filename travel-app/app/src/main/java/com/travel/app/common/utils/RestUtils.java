package com.travel.app.common.utils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.travel.app.common.DataStatic;
import com.travel.app.common.response.ApiResponse;

import java.io.IOException;
import java.util.List;

import retrofit2.Response;

public class RestUtils<T> {

    public static <T> ApiResponse<T> get(Response<ApiResponse<T>> response){
        if (response.raw().code() != DataStatic.HttpStatus.SUCCESS && response.errorBody() != null){
            try {
                return new Gson().fromJson(response.errorBody().string(), ApiResponse.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (response.body() != null && response.body().getStatus().equals(DataStatic.HttpStatus.SUCCESS)){
            return response.body();
        }
        return null;
    }
}
