package com.travel.app.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.travel.app.common.response.ApiResponse;
import com.travel.app.data.model.User;
import com.travel.app.repository.UserRepository;

public class ProfileViewModel extends AndroidViewModel {

    private UserRepository userRepository;

    public ProfileViewModel(@NonNull Application application) {
        super(application);
        this.userRepository = new UserRepository();
    }

    public LiveData<ApiResponse<User>> info(String token){
        return this.userRepository.info(token);
    }

    public LiveData<ApiResponse<User>> update(String token, User user){
        return this.userRepository.update(token, user);
    }
}
