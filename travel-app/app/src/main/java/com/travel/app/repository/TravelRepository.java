package com.travel.app.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.travel.app.common.DataStatic;
import com.travel.app.common.reponse.ApiResponse;
import com.travel.app.data.model.Travel;
import com.travel.app.retrofit.ApiRequest;
import com.travel.app.retrofit.RetrofitRequest;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.HTTP;

public class TravelRepository {
    private final ApiRequest apiRequest;

    public TravelRepository(){
        apiRequest = RetrofitRequest.instance().create(ApiRequest.class);
    }

    public LiveData<List<Travel>> getTravelAds(){
        final MutableLiveData<List<Travel>> data = new MutableLiveData<>();
        try {
            apiRequest.getTravelAds().enqueue(new Callback<ApiResponse<List<Travel>>>() {
                @Override
                public void onResponse(Call<ApiResponse<List<Travel>>> call, Response<ApiResponse<List<Travel>>> response) {
                    if(response.body() != null && response.body().getStatus().equals(DataStatic.HttpStatus.SUCCESS)) data.setValue(response.body().getResult());
                }

                @Override
                public void onFailure(Call<ApiResponse<List<Travel>>> call, Throwable t) {

                }
            });
        }catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
