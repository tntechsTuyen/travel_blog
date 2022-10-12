package com.travel.app.view.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.travel.app.MainActivity;
import com.travel.app.R;
import com.travel.app.data.model.Travel;
import com.travel.app.view.adapter.AdapterTravel;
import com.travel.app.view.adapter.AdapterTravelAds;
import com.travel.app.view.adapter.AdapterTravelCity;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class FragmentMainTravelCity extends Fragment {

    private static final Integer RES_ID = R.layout.fragment_main_travel_city;
    private MainActivity context;
    private View view;
    private RecyclerView rvTravel;

    private AdapterTravel adapterTravel;
    private List<Travel> listTravel;

    @SuppressLint("ValidFragment")
    public FragmentMainTravelCity(MainActivity mContext){
        this.context = mContext;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(RES_ID, container, false);
        //init view
        this.init();
        this.actionView();
        return this.view;
    }

    public void init(){
        this.rvTravel = this.view.findViewById(R.id.rv_travel);
        loadTravel();
        this.adapterTravel = new AdapterTravel(this.context, this.listTravel);
        this.rvTravel.setAdapter(this.adapterTravel);
        this.rvTravel.setLayoutManager(new LinearLayoutManager(context));
    }

    public void loadTravel(){
        this.listTravel = new ArrayList<>();
        this.listTravel.add(new Travel());
        this.listTravel.add(new Travel());
        this.listTravel.add(new Travel());
        this.listTravel.add(new Travel());
        this.listTravel.add(new Travel());
        this.listTravel.add(new Travel());
        this.listTravel.add(new Travel());
    }

    public void actionView(){

    }
}
