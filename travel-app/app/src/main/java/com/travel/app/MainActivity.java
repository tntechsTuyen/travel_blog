package com.travel.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.travel.app.data.model.User;
import com.travel.app.view.fragment.FragmentMainHome;
import com.travel.app.view.fragment.FragmentMainHotelDetail;
import com.travel.app.view.fragment.FragmentMainTravelCity;
import com.travel.app.view.fragment.FragmentMainTravelDetail;
import com.travel.app.view.fragment.FragmentSignIn;
import com.travel.app.viewmodel.MainViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private MainViewModel mainViewModel;
    private FragmentMainHome fragmentMainHome = null;
    private FragmentMainTravelCity fragmentMainTravelCity = null;
    private FragmentMainTravelDetail fragmentMainTravelDetail = null;
    private FragmentMainHotelDetail fragmentMainHotelDetail = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.init();
        this.actionView();
        this.setFragmentMainHome();
    }

    private void init(){
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
//        getTravel();
    }

    private void actionView(){

    }

    private void getTravel(){
        mainViewModel.getTravelRepositoryLiveData().observe(this, data -> {
            for(int i = 0; i < data.size(); i++){
                Log.i(TAG, data.get(i).toString());
            }
        });
    }

    public void setFragmentMainHome(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if(fragmentMainHome == null){
            fragmentMainHome = new FragmentMainHome(MainActivity.this);
        }
        transaction.replace(R.id.layout_content, fragmentMainHome).commitAllowingStateLoss();
    }

    public void setFragmentMainTravelCity(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if(fragmentMainTravelCity == null){
            fragmentMainTravelCity = new FragmentMainTravelCity(MainActivity.this);
        }
        transaction.replace(R.id.layout_content, fragmentMainTravelCity).commitAllowingStateLoss();
    }

    public void setFragmentMainTravelDetail(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if(fragmentMainTravelDetail == null){
            fragmentMainTravelDetail = new FragmentMainTravelDetail(MainActivity.this);
        }
        transaction.replace(R.id.layout_content, fragmentMainTravelDetail).commitAllowingStateLoss();
    }

    public void setFragmentMainHotelDetail(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if(fragmentMainHotelDetail == null){
            fragmentMainHotelDetail = new FragmentMainHotelDetail(MainActivity.this);
        }
        transaction.replace(R.id.layout_content, fragmentMainHotelDetail).commitAllowingStateLoss();
    }
}