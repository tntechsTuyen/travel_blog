package com.travel.app.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.travel.app.common.reponse.ApiResponse;
import com.travel.app.data.model.Travel;
import com.travel.app.data.model.User;
import com.travel.app.repository.TravelRepository;
import com.travel.app.repository.UserRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private TravelRepository travelRepository;
    private LiveData<List<Travel>> travelRepositoryLiveData;

    public MainViewModel(@NonNull Application application) {
        super(application);
        this.travelRepository = new TravelRepository();
        this.travelRepositoryLiveData = this.travelRepository.getTravelAds();
    }

    public LiveData<List<Travel>> getTravelRepositoryLiveData(){
        return this.travelRepositoryLiveData;
    }
}