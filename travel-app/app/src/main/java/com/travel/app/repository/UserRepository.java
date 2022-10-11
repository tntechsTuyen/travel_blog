package com.travel.app.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.travel.app.data.model.User;
import com.travel.app.retrofit.ApiRequest;
import com.travel.app.retrofit.RetrofitRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private static final String TAG = UserRepository.class.getSimpleName();
    private final ApiRequest apiRequest;

    public UserRepository(){
        apiRequest = RetrofitRequest.instance().create(ApiRequest.class);
    }
    
    public LiveData<List<User>> getData(){
        final MutableLiveData<List<User>> data = new MutableLiveData<>();
        try{

            apiRequest.getUser().enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                    Log.d(TAG, "onResponse response:: " + response);
                    if (response.body() != null) {
                        data.setValue(response.body());
                        Log.d(TAG, "articles total result:: " + response.body());
                        Log.d(TAG, "size:: " + response.body());
                    }
                }

                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {
                    Log.e(TAG, "onFailure "+t.getMessage());
                    data.setValue(null);
                }
            });
        }catch (Exception e){
            Log.e(TAG, "Ex: "+e.getMessage());
        }
        return data;
    }

}
