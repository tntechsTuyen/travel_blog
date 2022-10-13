package com.travel.app.view.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.travel.app.AuthActivity;
import com.travel.app.MainActivity;
import com.travel.app.R;
import com.travel.app.common.utils.ViewUtils;
import com.travel.app.data.model.Travel;
import com.travel.app.view.adapter.AdapterTravel;
import com.travel.app.view.adapter.AdapterTravelAds;
import com.travel.app.view.adapter.AdapterTravelCity;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class FragmentMainHome extends Fragment {

    private static final Integer RES_ID = R.layout.fragment_main_home;
    private MainActivity context;
    private View view;
    private RecyclerView rvTravelAds, rvTravelTop, rvTravelHobbies, rvTravelCity;

    private AdapterTravelAds adapterTravelAds;
    private AdapterTravel adapterTravelTop, adapterTravelHobbies;
    private AdapterTravelCity adapterTravelCity;
    private List<Travel> listTravelAds, listTravelTop, listTravelHobbies;
    private List<String> listTravelCity;

    @SuppressLint("ValidFragment")
    public FragmentMainHome(MainActivity mContext){
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
        this.rvTravelAds = this.view.findViewById(R.id.rv_travel_ads);
        loadTravelAds();
        this.adapterTravelAds = new AdapterTravelAds(this.context, this.listTravelAds);
        this.rvTravelAds.setAdapter(this.adapterTravelAds);
        this.rvTravelAds.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

        this.rvTravelTop = this.view.findViewById(R.id.rv_travel_top);
        loadTravelTop();
        this.adapterTravelTop = new AdapterTravel(this.context, this.listTravelTop);
        this.rvTravelTop.setAdapter(this.adapterTravelTop);
        this.rvTravelTop.setLayoutManager(new LinearLayoutManager(context));

        this.rvTravelHobbies = this.view.findViewById(R.id.rv_travel_hobbies);
        loadTravelHobbies();
        this.adapterTravelHobbies = new AdapterTravel(this.context, this.listTravelHobbies);
        this.rvTravelHobbies.setAdapter(this.adapterTravelHobbies);
        this.rvTravelHobbies.setLayoutManager(new LinearLayoutManager(context));

        this.rvTravelCity = this.view.findViewById(R.id.rv_travel_city);
        loadTravelCity();
        this.adapterTravelCity = new AdapterTravelCity(this.context, this.listTravelCity);
        this.rvTravelCity.setAdapter(this.adapterTravelCity);
        this.rvTravelCity.setLayoutManager(new LinearLayoutManager(context));
    }

    public void loadTravelAds(){
        this.listTravelAds = new ArrayList<>();
        this.listTravelAds.add(new Travel());
        this.listTravelAds.add(new Travel());
        this.listTravelAds.add(new Travel());
        this.listTravelAds.add(new Travel());
        this.listTravelAds.add(new Travel());
        this.listTravelAds.add(new Travel());
        this.listTravelAds.add(new Travel());
    }
    public void loadTravelTop(){
        this.listTravelTop = new ArrayList<>();
        this.listTravelTop.add(new Travel());
        this.listTravelTop.add(new Travel());
        this.listTravelTop.add(new Travel());
        this.listTravelTop.add(new Travel());
        this.listTravelTop.add(new Travel());
    }

    public void loadTravelHobbies(){
        this.listTravelHobbies = new ArrayList<>();
        this.listTravelHobbies.add(new Travel());
        this.listTravelHobbies.add(new Travel());
        this.listTravelHobbies.add(new Travel());
        this.listTravelHobbies.add(new Travel());
        this.listTravelHobbies.add(new Travel());
        this.listTravelHobbies.add(new Travel());
        this.listTravelHobbies.add(new Travel());
    }

    public void loadTravelCity(){
        this.listTravelCity = new ArrayList<>();
        this.listTravelCity.add("");
        this.listTravelCity.add("");
        this.listTravelCity.add("");
        this.listTravelCity.add("");
        this.listTravelCity.add("");
        this.listTravelCity.add("");
        this.listTravelCity.add("");
        this.listTravelCity.add("");
    }

    public void actionView(){

    }

    @Override
    public void onPause() {
        super.onPause();
        ViewUtils.show(this.context.getToolbar().getTwaBtnBack());
    }

    @Override
    public void onResume() {
        super.onResume();
        ViewUtils.hide(this.context.getToolbar().getTwaBtnBack());
    }
}
