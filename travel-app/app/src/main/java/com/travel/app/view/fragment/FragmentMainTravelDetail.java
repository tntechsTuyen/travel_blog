package com.travel.app.view.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.travel.app.MainActivity;
import com.travel.app.R;
import com.travel.app.data.model.Comment;
import com.travel.app.data.model.Hotel;
import com.travel.app.data.model.Travel;
import com.travel.app.data.model.TravelMeta;
import com.travel.app.view.adapter.AdapterComment;
import com.travel.app.view.adapter.AdapterTravel;
import com.travel.app.view.adapter.AdapterTravelHotel;
import com.travel.app.view.adapter.AdapterTravelMeta;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class FragmentMainTravelDetail extends Fragment {

    private static final Integer RES_ID = R.layout.fragment_main_travel_detail;
    private MainActivity context;
    private View view;
    private RecyclerView rvHotel, rvComment, rvTravelMeta;
    private AdapterTravelHotel adapterTravelHotel;
    private AdapterComment adapterComment;
    private AdapterTravelMeta adapterTravelMeta;
    private List<Hotel> listHotel;
    private List<Comment> listComment;
    private List<TravelMeta> listTravelMeta;
    private Travel travel = null;

    @SuppressLint("ValidFragment")
    public FragmentMainTravelDetail(MainActivity mContext){
        this.context = mContext;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(RES_ID, container, false);
        //init view
        this.init();
        return this.view;
    }

    public void init(){

        this.rvHotel = this.view.findViewById(R.id.rv_travel_hotel);
        this.listHotel = new ArrayList<>();
        this.adapterTravelHotel = new AdapterTravelHotel(this.context, this.listHotel);
        this.rvHotel.setAdapter(this.adapterTravelHotel);
        this.rvHotel.setLayoutManager(new LinearLayoutManager(context));

        this.rvComment = this.view.findViewById(R.id.rv_comment);
        this.listComment = new ArrayList<>();
        this.adapterComment = new AdapterComment(this.context, this.listComment);
        this.rvComment.setAdapter(this.adapterComment);
        this.rvComment.setLayoutManager(new LinearLayoutManager(context));

        this.rvTravelMeta = this.view.findViewById(R.id.rv_travel_meta);
        this.listTravelMeta = new ArrayList<>();
        this.adapterTravelMeta = new AdapterTravelMeta(this.context, this.listTravelMeta);
        this.rvTravelMeta.setAdapter(this.adapterTravelMeta);
        this.rvTravelMeta.setLayoutManager(new LinearLayoutManager(context));
    }

    public void change(Travel travel){
        if(this.travel == null || !this.travel.getId().equals(travel.getId())){
            this.travel = travel;
            loadData();
        }
    }

    public void loadData(){

        loadDetail();
        loadTravelMeta();
        loadHotel();
        loadComment();
    }

    public void loadDetail(){

    }

    public void loadHotel(){

    }

    public void loadComment(){
    }

    public void loadTravelMeta(){
    }

    public void actionView(){

    }
}
