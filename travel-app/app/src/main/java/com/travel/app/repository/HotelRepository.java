package com.travel.app.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.travel.app.common.response.ApiResponse;
import com.travel.app.common.utils.RestUtils;
import com.travel.app.data.model.Hotel;
import com.travel.app.data.model.HotelMeta;
import com.travel.app.data.model.Location;
import com.travel.app.retrofit.HotelRequest;
import com.travel.app.retrofit.LocationRequest;
import com.travel.app.retrofit.RetrofitRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotelRepository {
    private final HotelRequest hotelRequest;

    public HotelRepository(){
        hotelRequest = RetrofitRequest.instance().create(HotelRequest.class);
    }

    public LiveData<ApiResponse<Hotel>> getDetail(String token, Integer id){
        MutableLiveData<ApiResponse<Hotel>> data = new MutableLiveData<>();
        token = (token != null & token.trim().length() > 0) ? "Bearer ".concat(token).replaceAll("\"", "") : "";
        hotelRequest.getDetail(token, id).enqueue(new Callback<ApiResponse<Hotel>>() {
            @Override
            public void onResponse(Call<ApiResponse<Hotel>> call, Response<ApiResponse<Hotel>> response) {
                data.setValue(RestUtils.get(response));
            }

            @Override
            public void onFailure(Call<ApiResponse<Hotel>> call, Throwable t) {

            }
        });
        return data;
    }

    public LiveData<ApiResponse<List<HotelMeta>>> getMetas(Integer id){
        MutableLiveData<ApiResponse<List<HotelMeta>>> data = new MutableLiveData<>();
        hotelRequest.getMetas(id).enqueue(new Callback<ApiResponse<List<HotelMeta>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<HotelMeta>>> call, Response<ApiResponse<List<HotelMeta>>> response) {
                data.setValue(RestUtils.get(response));
            }

            @Override
            public void onFailure(Call<ApiResponse<List<HotelMeta>>> call, Throwable t) {

            }
        });
        return data;
    }


}
