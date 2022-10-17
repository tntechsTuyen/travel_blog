package com.travel.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.travel.app.common.DataStatic;
import com.travel.app.common.utils.SessionUtils;
import com.travel.app.common.view.toolbar.MyToolbar;
import com.travel.app.data.model.Hotel;
import com.travel.app.data.model.Location;
import com.travel.app.data.model.Travel;
import com.travel.app.view.dialog.DialogMainMenu;
import com.travel.app.view.fragment.FragmentMainHome;
import com.travel.app.view.fragment.FragmentMainHotelDetail;
import com.travel.app.view.fragment.FragmentMainSetting;
import com.travel.app.view.fragment.FragmentMainTravelCity;
import com.travel.app.view.fragment.FragmentMainTravelDetail;
import com.travel.app.view.fragment.FragmentMainTravelSearch;
import com.travel.app.viewmodel.HomeViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private HomeViewModel homeViewModel;
    private FragmentMainHome fragmentMainHome = null;
    private FragmentMainTravelCity fragmentMainTravelCity = null;
    private FragmentMainTravelDetail fragmentMainTravelDetail = null;
    private FragmentMainHotelDetail fragmentMainHotelDetail = null;
    private FragmentMainTravelSearch fragmentMainTravelSearch = null;
    private FragmentMainSetting fragmentMainSetting = null;

    private MyToolbar toolbar;
    private DialogMainMenu dialogMainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.init();
        this.actionView();
        this.setFragmentMainHome();
    }

    private void init(){
        this.homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        this.toolbar = new MyToolbar(this);
        this.dialogMainMenu = new DialogMainMenu(this);
    }

    private void actionView(){
        this.toolbar.getTwaMenuMore().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogMainMenu.show();
            }
        });

        this.toolbar.getTwaBtnBack().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    public void setFragmentMainHome(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        fragmentMainHome = new FragmentMainHome(MainActivity.this);
        transaction.replace(R.id.layout_content, fragmentMainHome).commitAllowingStateLoss();
    }

    public void setFragmentMainTravelCity(Location location){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        fragmentMainTravelCity = new FragmentMainTravelCity(MainActivity.this, location);
        transaction.replace(R.id.layout_content, fragmentMainTravelCity).addToBackStack(DataStatic.STACK_APP);
        transaction.commit();
    }

    public void setFragmentMainTravelDetail(Travel travel){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        fragmentMainTravelDetail = new FragmentMainTravelDetail(MainActivity.this, travel);
        transaction.replace(R.id.layout_content, fragmentMainTravelDetail).addToBackStack(DataStatic.STACK_APP);
        transaction.commit();
    }

    public void setFragmentMainHotelDetail(Hotel hotel){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        fragmentMainHotelDetail = new FragmentMainHotelDetail(MainActivity.this, hotel);
        transaction.replace(R.id.layout_content, fragmentMainHotelDetail).addToBackStack(DataStatic.STACK_APP);
        transaction.commit();
    }

    public void setFragmentMainTravelSearch(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        fragmentMainTravelSearch = new FragmentMainTravelSearch(MainActivity.this);
        transaction.replace(R.id.layout_content, fragmentMainTravelSearch).addToBackStack(DataStatic.STACK_APP);
        transaction.commit();
    }

    public void setFragmentMainSetting(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        fragmentMainSetting = new FragmentMainSetting(MainActivity.this);
        transaction.replace(R.id.layout_content, fragmentMainSetting).addToBackStack(DataStatic.STACK_APP);
        transaction.commit();
    }

    public MyToolbar getToolbar(){
        return this.toolbar;
    }

    public HomeViewModel getHomeViewModel() {
        return this.homeViewModel;
    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        } else {
            getFragmentManager().popBackStack();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.dialogMainMenu.updateViewAuth();
    }
}