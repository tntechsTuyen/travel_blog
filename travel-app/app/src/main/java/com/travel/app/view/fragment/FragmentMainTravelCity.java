package com.travel.app.view.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.travel.app.MainActivity;
import com.travel.app.R;
import com.travel.app.data.model.Location;
import com.travel.app.data.model.Travel;
import com.travel.app.view.adapter.AdapterTravel;
import com.travel.app.view.adapter.AdapterTravelAds;
import com.travel.app.view.adapter.AdapterTravelCity;

import java.util.ArrayList;
import java.util.List;

@SuppressLint({"ValidFragment", "NotifyDataSetChanged"})
public class FragmentMainTravelCity extends Fragment {

    private static final Integer RES_ID = R.layout.fragment_main_travel_city;
    private MainActivity context;
    private View view;
    private RecyclerView rvTravel;
    private TextView tvNameCity;

    private AdapterTravel adapterTravel;
    private List<Travel> listTravel;
    private Location location = null;

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
        this.listTravel = new ArrayList<>();
        this.rvTravel = this.view.findViewById(R.id.rv_travel);
        this.adapterTravel = new AdapterTravel(this.context, this.listTravel);
        this.rvTravel.setAdapter(this.adapterTravel);
        this.rvTravel.setLayoutManager(new LinearLayoutManager(context));
        this.tvNameCity = this.view.findViewById(R.id.tv_city_name);
    }

    public void changeData(@NonNull Location location){
        if(this.location == null || !this.location.getCode().equals(location.getCode())){
            this.location = location;
        }
    }

    public void loadTravel(){
        String name = this.location.getCity().concat(" (").concat(this.location.getCode().toString()).concat(") ");
        this.tvNameCity.setText(name);
        this.context.getHomeViewModel().getTravelByCity(this.location.getCode()).observe(context, res -> {
            if(res.getResult() != null && res.getResult().size() > 0){
                this.listTravel.clear();
                this.listTravel.addAll(res.getResult());
                this.adapterTravel.notifyDataSetChanged();
            }
        });
    }

    public void actionView(){

    }

    @Override
    public void onResume() {
        super.onResume();
        loadTravel();
    }
}
