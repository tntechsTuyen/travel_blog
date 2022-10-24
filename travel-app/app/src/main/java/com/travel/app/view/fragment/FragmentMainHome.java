package com.travel.app.view.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.travel.app.MainActivity;
import com.travel.app.R;
import com.travel.app.common.DataStatic;
import com.travel.app.common.utils.SessionUtils;
import com.travel.app.common.utils.ViewUtils;
import com.travel.app.data.model.Location;
import com.travel.app.data.model.Travel;
import com.travel.app.view.adapter.AdapterTravel;
import com.travel.app.view.adapter.AdapterTravelAds;
import com.travel.app.view.adapter.AdapterTravelCity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@SuppressLint({"ValidFragment","NotifyDataSetChanged"})
public class FragmentMainHome extends Fragment {

    private static final Integer RES_ID = R.layout.fragment_main_home;
    private MainActivity context;
    private View view;
    private RecyclerView rvTravelTop, rvTravelHobbies, rvTravelCity;
    private ViewPager vpTravelAds;
    private Group grAuth;

    private AdapterTravelAds adapterTravelAds;
    private AdapterTravel adapterTravelTop, adapterTravelHobbies;
    private AdapterTravelCity adapterTravelCity;
    private List<Travel> listTravelAds, listTravelTop, listTravelHobbies;
    private List<Location> listTravelCity;

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
//        this.actionView();
        return this.view;
    }

    public void init(){
        this.vpTravelAds = this.view.findViewById(R.id.vp_travel_ads);
        this.listTravelAds = new ArrayList<>();
        this.adapterTravelAds = new AdapterTravelAds(this.context, this.listTravelAds);
        this.vpTravelAds.setAdapter(this.adapterTravelAds);
        loadTravelAds();
        slideAdsLoading();

        this.rvTravelTop = this.view.findViewById(R.id.rv_travel_top);
        this.listTravelTop = new ArrayList<>();
        this.adapterTravelTop = new AdapterTravel(this.context, this.listTravelTop);
        this.rvTravelTop.setAdapter(this.adapterTravelTop);
        this.rvTravelTop.setLayoutManager(new LinearLayoutManager(context));
        loadTravelTop();

        this.grAuth = this.view.findViewById(R.id.gr_auth);
        this.rvTravelHobbies = this.view.findViewById(R.id.rv_travel_hobbies);
        this.listTravelHobbies = new ArrayList<>();
        this.adapterTravelHobbies = new AdapterTravel(this.context, this.listTravelHobbies);
        this.rvTravelHobbies.setAdapter(this.adapterTravelHobbies);
        this.rvTravelHobbies.setLayoutManager(new LinearLayoutManager(context));

        this.rvTravelCity = this.view.findViewById(R.id.rv_travel_city);
        this.listTravelCity = new ArrayList<>();
        this.adapterTravelCity = new AdapterTravelCity(this.context, this.listTravelCity);
        this.rvTravelCity.setAdapter(this.adapterTravelCity);
        this.rvTravelCity.setLayoutManager(new LinearLayoutManager(context));
        loadTravelCity();

    }

    public void loadTravelAds(){
        this.context.getHomeViewModel().getAds().observe(context, res -> {
            if(res.getResult() != null && res.getResult().size() > 0){
                this.listTravelAds.addAll(res.getResult());
                this.adapterTravelAds.notifyDataSetChanged();
            }
        });
    }

    private void slideAdsLoading(){
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int max = adapterTravelAds.getCount();
                int min = 0;
                if(vpTravelAds.getCurrentItem() >= min && vpTravelAds.getCurrentItem() < max-1){
                    vpTravelAds.setCurrentItem(vpTravelAds.getCurrentItem()+1);
                }else{
                    vpTravelAds.setCurrentItem(0);
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 10000, 10000);
    }

    public void loadTravelTop(){
        this.context.getHomeViewModel().getTops().observe(context, res -> {
            if(res.getResult() != null && res.getResult().size() > 0){
                this.listTravelTop.addAll(res.getResult());
                this.adapterTravelTop.notifyDataSetChanged();
            }
        });
    }

    public void loadTravelHobbies(String token){
        this.context.getHomeViewModel().getMyHobbies(token).observe(context, res -> {
            if(res.getResult() != null && res.getResult().size() > 0){
                this.listTravelHobbies.addAll(res.getResult());
                this.adapterTravelHobbies.notifyDataSetChanged();
            }
        });
    }

    public void loadTravelCity(){
        this.context.getHomeViewModel().getCity().observe(context, res -> {
            if(res.getResult() != null && res.getResult().size() > 0){
                this.listTravelCity.addAll(res.getResult());
                this.adapterTravelCity.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        ViewUtils.show(this.context.getToolbar().getTwaBtnBack());
    }

    @Override
    public void onStart() {
        super.onStart();
        ViewUtils.hide(this.context.getToolbar().getTwaBtnBack());
        String token = SessionUtils.get(this.context, DataStatic.SESSION.KEY.AUTH, "");
        if(token != null && token.trim().length() > 0){
            loadTravelHobbies(token);
            this.grAuth.setVisibility(View.VISIBLE);
        }
    }
}
