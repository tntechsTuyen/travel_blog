package com.travel.app.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.travel.app.common.response.ApiResponse;
import com.travel.app.data.model.User;
import com.travel.app.repository.UserRepository;

public class AuthViewModel extends AndroidViewModel {

    private UserRepository userRepository;

    public AuthViewModel(@NonNull Application application) {
        super(application);
        this.userRepository = new UserRepository();
    }

    public LiveData<ApiResponse<String>> login(User user){
        return this.userRepository.login(user);
    }

    public LiveData<ApiResponse<User>> register(User user){
        return this.userRepository.register(user);
    }
}