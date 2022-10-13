package com.travel.app.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.travel.app.common.response.ApiResponse;
import com.travel.app.common.utils.RestUtils;
import com.travel.app.data.model.Location;
import com.travel.app.data.model.Travel;
import com.travel.app.retrofit.LocationRequest;
import com.travel.app.retrofit.RetrofitRequest;
import com.travel.app.retrofit.TravelRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationRepository {
    private final LocationRequest locationRequest;

    public LocationRepository(){
        locationRequest = RetrofitRequest.instance().create(LocationRequest.class);
    }

    public LiveData<ApiResponse<List<Location>>> getList(){
        MutableLiveData<ApiResponse<List<Location>>> data = new MutableLiveData<>();
        locationRequest.getList().enqueue(new Callback<ApiResponse<List<Location>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Location>>> call, Response<ApiResponse<List<Location>>> response) {
                data.setValue(RestUtils.get(response));
            }

            @Override
            public void onFailure(Call<ApiResponse<List<Location>>> call, Throwable t) {

            }
        });
        return data;
    }


}
