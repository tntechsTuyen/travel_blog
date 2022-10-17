package com.travel.app.repository;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.travel.app.common.DataStatic;
import com.travel.app.common.response.ApiResponse;
import com.travel.app.common.utils.RestUtils;
import com.travel.app.common.utils.SessionUtils;
import com.travel.app.data.model.Hotel;
import com.travel.app.data.model.Travel;
import com.travel.app.data.model.TravelMeta;
import com.travel.app.retrofit.AuthRequest;
import com.travel.app.retrofit.RetrofitRequest;
import com.travel.app.retrofit.TravelRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TravelRepository {
    private final TravelRequest travelRequest;

    public TravelRepository(){
        travelRequest = RetrofitRequest.instance().create(TravelRequest.class);
    }

    public LiveData<ApiResponse<List<Travel>>> getList(String search){
        MutableLiveData<ApiResponse<List<Travel>>> data = new MutableLiveData<>();
        travelRequest.getList(search).enqueue(new Callback<ApiResponse<List<Travel>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Travel>>> call, Response<ApiResponse<List<Travel>>> response) {
                data.setValue(RestUtils.get(response));
            }

            @Override
            public void onFailure(Call<ApiResponse<List<Travel>>> call, Throwable t) {

            }
        });
        return data;
    }

    public LiveData<ApiResponse<List<Travel>>> getAds(){
        MutableLiveData<ApiResponse<List<Travel>>> data = new MutableLiveData<>();
        travelRequest.getAds().enqueue(new Callback<ApiResponse<List<Travel>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Travel>>> call, Response<ApiResponse<List<Travel>>> response) {
                data.setValue(RestUtils.get(response));
            }

            @Override
            public void onFailure(Call<ApiResponse<List<Travel>>> call, Throwable t) {

            }
        });
        return data;
    }

    public LiveData<ApiResponse<List<Travel>>> getTop(){
        MutableLiveData<ApiResponse<List<Travel>>> data = new MutableLiveData<>();
        travelRequest.getTop().enqueue(new Callback<ApiResponse<List<Travel>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Travel>>> call, Response<ApiResponse<List<Travel>>> response) {
                data.setValue(RestUtils.get(response));
            }

            @Override
            public void onFailure(Call<ApiResponse<List<Travel>>> call, Throwable t) {

            }
        });
        return data;
    }

    public LiveData<ApiResponse<List<Travel>>> getByCityCode(Integer zipCode){
        MutableLiveData<ApiResponse<List<Travel>>> data = new MutableLiveData<>();
        travelRequest.getByCity(zipCode).enqueue(new Callback<ApiResponse<List<Travel>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Travel>>> call, Response<ApiResponse<List<Travel>>> response) {
                data.setValue(RestUtils.get(response));
            }

            @Override
            public void onFailure(Call<ApiResponse<List<Travel>>> call, Throwable t) {

            }
        });
        return data;
    }

    public LiveData<ApiResponse<List<Travel>>> getMyHobbies(String token){
        MutableLiveData<ApiResponse<List<Travel>>> data = new MutableLiveData<>();
        token = "Bearer ".concat(token).replaceAll("\"", "");
        travelRequest.getMyHobbies(token).enqueue(new Callback<ApiResponse<List<Travel>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Travel>>> call, Response<ApiResponse<List<Travel>>> response) {
                data.setValue(RestUtils.get(response));
            }

            @Override
            public void onFailure(Call<ApiResponse<List<Travel>>> call, Throwable t) {

            }
        });
        return data;
    }

    public LiveData<ApiResponse<Travel>> getDetail(String token, Integer id){
        MutableLiveData<ApiResponse<Travel>> data = new MutableLiveData<>();

        token = (token != null & token.trim().length() > 0) ? "Bearer ".concat(token).replaceAll("\"", "") : "";
        travelRequest.getDetail(token, id).enqueue(new Callback<ApiResponse<Travel>>() {
            @Override
            public void onResponse(Call<ApiResponse<Travel>> call, Response<ApiResponse<Travel>> response) {
                data.setValue(RestUtils.get(response));
            }

            @Override
            public void onFailure(Call<ApiResponse<Travel>> call, Throwable t) {

            }
        });
        return data;
    }

    public LiveData<ApiResponse<List<Hotel>>> getHotels(Integer id){
        MutableLiveData<ApiResponse<List<Hotel>>> data = new MutableLiveData<>();
        travelRequest.getTravelHotel(id).enqueue(new Callback<ApiResponse<List<Hotel>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Hotel>>> call, Response<ApiResponse<List<Hotel>>> response) {
                data.setValue(RestUtils.get(response));
            }

            @Override
            public void onFailure(Call<ApiResponse<List<Hotel>>> call, Throwable t) {

            }
        });
        return data;
    }

    public LiveData<ApiResponse<List<TravelMeta>>> getMetas(Integer id){
        MutableLiveData<ApiResponse<List<TravelMeta>>> data = new MutableLiveData<>();
        travelRequest.getTravelMetas(id).enqueue(new Callback<ApiResponse<List<TravelMeta>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<TravelMeta>>> call, Response<ApiResponse<List<TravelMeta>>> response) {
                data.setValue(RestUtils.get(response));
            }

            @Override
            public void onFailure(Call<ApiResponse<List<TravelMeta>>> call, Throwable t) {

            }
        });
        return data;
    }

}
