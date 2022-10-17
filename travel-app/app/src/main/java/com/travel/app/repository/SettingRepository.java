package com.travel.app.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.travel.app.common.response.ApiResponse;
import com.travel.app.common.utils.RestUtils;
import com.travel.app.data.model.Hotel;
import com.travel.app.data.model.HotelMeta;
import com.travel.app.data.model.Tag;
import com.travel.app.retrofit.HotelRequest;
import com.travel.app.retrofit.RetrofitRequest;
import com.travel.app.retrofit.SettingRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SettingRepository {
    private final SettingRequest settingRequest;

    public SettingRepository(){
        settingRequest = RetrofitRequest.instance().create(SettingRequest.class);
    }

    public LiveData<ApiResponse<List<Tag>>> getTagList(String token){
        MutableLiveData<ApiResponse<List<Tag>>> data = new MutableLiveData<>();
        token = "Bearer ".concat(token).replaceAll("\"", "");
        settingRequest.getTagList(token).enqueue(new Callback<ApiResponse<List<Tag>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Tag>>> call, Response<ApiResponse<List<Tag>>> response) {
                data.setValue(RestUtils.get(response));
            }

            @Override
            public void onFailure(Call<ApiResponse<List<Tag>>> call, Throwable t) {

            }
        });
        return data;
    }

    public LiveData<ApiResponse<Boolean>> postTagUpdate(String token, List<Integer> idTags){
        MutableLiveData<ApiResponse<Boolean>> data = new MutableLiveData<>();
        token = "Bearer ".concat(token).replaceAll("\"", "");
        settingRequest.postTagUpdate(token, idTags).enqueue(new Callback<ApiResponse<Boolean>>() {
            @Override
            public void onResponse(Call<ApiResponse<Boolean>> call, Response<ApiResponse<Boolean>> response) {
                data.setValue(RestUtils.get(response));
            }

            @Override
            public void onFailure(Call<ApiResponse<Boolean>> call, Throwable t) {

            }
        });
        return data;
    }


}
