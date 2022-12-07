package com.travel.app.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.travel.app.common.DataStatic;
import com.travel.app.common.response.ApiResponse;
import com.travel.app.common.utils.RestUtils;
import com.travel.app.data.model.User;
import com.travel.app.retrofit.AuthRequest;
import com.travel.app.retrofit.RetrofitRequest;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private final AuthRequest authRequest;

    public UserRepository(){
        this.authRequest = RetrofitRequest.instance().create(AuthRequest.class);
    }
    
    public LiveData<ApiResponse<String>> login(User user){
        MutableLiveData<ApiResponse<String>> data = new MutableLiveData<>();
        try{
            this.authRequest.login(user).enqueue(new Callback<ApiResponse<String>>() {
                @Override
                public void onResponse(Call<ApiResponse<String>> call, Response<ApiResponse<String>> response) {
                    data.setValue(RestUtils.get(response));
                }

                @Override
                public void onFailure(Call<ApiResponse<String>> call, Throwable t) {
                    Log.e("UserRepository", "onFailure: ", t);
                }

            });
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    public LiveData<ApiResponse<User>> register(User user){
        MutableLiveData<ApiResponse<User>> data = new MutableLiveData<>();
        this.authRequest.register(user).enqueue(new Callback<ApiResponse<User>>() {
            @Override
            public void onResponse(Call<ApiResponse<User>> call, Response<ApiResponse<User>> response) {
                data.setValue(RestUtils.get(response));
            }

            @Override
            public void onFailure(Call<ApiResponse<User>> call, Throwable t) {

            }
        });
        return data;
    }

    public LiveData<ApiResponse<User>> info(String token){
        token = "Bearer ".concat(token).replaceAll("\"", "");
        MutableLiveData<ApiResponse<User>> data = new MutableLiveData<>();
        this.authRequest.userInfo(token).enqueue(new Callback<ApiResponse<User>>() {
            @Override
            public void onResponse(Call<ApiResponse<User>> call, Response<ApiResponse<User>> response) {
                data.setValue(RestUtils.get(response));
            }

            @Override
            public void onFailure(Call<ApiResponse<User>> call, Throwable t) {

            }
        });
        return data;
    }

    public LiveData<ApiResponse<User>> update(String token, User user){
        token = "Bearer ".concat(token).replaceAll("\"", "");
        MutableLiveData<ApiResponse<User>> data = new MutableLiveData<>();
        this.authRequest.userUpdate(token, user).enqueue(new Callback<ApiResponse<User>>() {
            @Override
            public void onResponse(Call<ApiResponse<User>> call, Response<ApiResponse<User>> response) {
                data.setValue(RestUtils.get(response));
            }

            @Override
            public void onFailure(Call<ApiResponse<User>> call, Throwable t) {

            }
        });
        return data;
    }

}
