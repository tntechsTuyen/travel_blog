package com.travel.app.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.travel.app.common.response.ApiResponse;
import com.travel.app.data.model.Location;
import com.travel.app.data.model.Travel;
import com.travel.app.repository.LocationRepository;
import com.travel.app.repository.TravelRepository;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    private TravelRepository travelRepository;
    private LocationRepository locationRepository;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        this.travelRepository = new TravelRepository();
        this.locationRepository = new LocationRepository();
    }

    public LiveData<ApiResponse<List<Travel>>> getAds(){
        return this.travelRepository.getAds();
    }

    public LiveData<ApiResponse<List<Travel>>> getTops(){
        return this.travelRepository.getTop();
    }

    public LiveData<ApiResponse<List<Travel>>> getMyHobbies(String token){
        return this.travelRepository.getMyHobbies(token);
    }

    public LiveData<ApiResponse<List<Travel>>> getByCity(Integer zipCode){
        return this.travelRepository.getByCityCode(zipCode);
    }

    public LiveData<ApiResponse<Travel>> getDetail(Integer id){
        return this.travelRepository.getDetail(id);
    }

    public LiveData<ApiResponse<List<Location>>> getCity(){
        return this.locationRepository.getList();
    }
}