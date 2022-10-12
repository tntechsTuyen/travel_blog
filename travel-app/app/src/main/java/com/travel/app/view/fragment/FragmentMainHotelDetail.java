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
import com.travel.app.data.model.Comment;
import com.travel.app.data.model.Hotel;
import com.travel.app.data.model.HotelMeta;
import com.travel.app.data.model.TravelMeta;
import com.travel.app.view.adapter.AdapterComment;
import com.travel.app.view.adapter.AdapterHotelMeta;
import com.travel.app.view.adapter.AdapterTravelHotel;
import com.travel.app.view.adapter.AdapterTravelMeta;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class FragmentMainHotelDetail extends Fragment {

    private static final Integer RES_ID = R.layout.fragment_main_hotel_detail;
    private MainActivity context;
    private View view;
    private RecyclerView rvComment, rvHotelMeta;
    private AdapterComment adapterComment;
    private AdapterHotelMeta adapterHotelMeta;
    private List<Comment> listComment;
    private List<HotelMeta> listHotelMeta;

    @SuppressLint("ValidFragment")
    public FragmentMainHotelDetail(MainActivity mContext){
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

        this.rvHotelMeta = this.view.findViewById(R.id.rv_hotel_meta);
        loadTravelMeta();
        this.adapterHotelMeta = new AdapterHotelMeta(this.context, this.listHotelMeta);
        this.rvHotelMeta.setAdapter(this.adapterHotelMeta);
        this.rvHotelMeta.setLayoutManager(new LinearLayoutManager(context));

        this.rvComment = this.view.findViewById(R.id.rv_comment);
        loadComment();
        this.adapterComment = new AdapterComment(this.context, this.listComment);
        this.rvComment.setAdapter(this.adapterComment);
        this.rvComment.setLayoutManager(new LinearLayoutManager(context));
    }

    public void loadComment(){
        this.listComment = new ArrayList<>();
        this.listComment.add(new Comment());
        this.listComment.add(new Comment());
    }

    public void loadTravelMeta(){
        this.listHotelMeta = new ArrayList<>();
        this.listHotelMeta.add(new HotelMeta());
        this.listHotelMeta.add(new HotelMeta());
        this.listHotelMeta.add(new HotelMeta());
        this.listHotelMeta.add(new HotelMeta());
        this.listHotelMeta.add(new HotelMeta());
    }

    public void actionView(){

    }
}
