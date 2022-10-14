package com.travel.app.view.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.travel.app.MainActivity;
import com.travel.app.R;
import com.travel.app.common.DataStatic;
import com.travel.app.common.utils.SessionUtils;
import com.travel.app.common.view.icon.TextViewAwsSo;
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

@SuppressLint({"ValidFragment","NotifyDataSetChanged","SetTextI18n"})
public class FragmentMainTravelDetail extends Fragment {

    private static final Integer RES_ID = R.layout.fragment_main_travel_detail;
    private MainActivity context;
    private View view;
    private Group grAuth;
    private RecyclerView rvHotel, rvComment, rvTravelMeta;
    private ImageView ivThumb;
    private TextView tvName, tvTotalView, tvTotalLike, tvDesc, tvRatePoint, btnGoMap, btnLike;
    private TextViewAwsSo btnSendCmt;
    private EditText etCmt;
    private AdapterTravelHotel adapterTravelHotel;
    private AdapterComment adapterComment;
    private AdapterTravelMeta adapterTravelMeta;
    private List<Hotel> listHotel;
    private List<Comment> listComment;
    private List<TravelMeta> listTravelMeta;
    private Travel travel = null;

    public FragmentMainTravelDetail(MainActivity mContext){
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

        this.ivThumb = this.view.findViewById(R.id.iv_thumb);
        this.tvName = this.view.findViewById(R.id.tv_name);
        this.tvTotalView = this.view.findViewById(R.id.tv_total_view);
        this.tvTotalLike = this.view.findViewById(R.id.tv_total_like);
        this.tvDesc = this.view.findViewById(R.id.tv_description);
        this.tvRatePoint = this.view.findViewById(R.id.tv_rate_point);
        this.btnGoMap = this.view.findViewById(R.id.btn_go_map);
        this.btnLike = this.view.findViewById(R.id.btn_like);
        this.etCmt = this.view.findViewById(R.id.et_cmt);
        this.btnSendCmt = this.view.findViewById(R.id.btn_send_cmt);
        this.grAuth = this.view.findViewById(R.id.gr_auth);
    }

    @Override
    public void onResume() {
        super.onResume();
        String token = SessionUtils.get(this.context, DataStatic.SESSION.KEY.AUTH, "");
        if(token != null && token.trim().length() > 0){
            this.grAuth.setVisibility(View.VISIBLE);
        }else{
            this.grAuth.setVisibility(View.GONE);
        }
        loadData();
    }

    public void change(Travel travel){
        if(this.travel == null || !this.travel.getId().equals(travel.getId())){
            this.travel = travel;
        }
    }

    public void loadData(){

        loadDetail();
        loadTravelMeta();
        loadHotel();
        loadComment();
    }

    public void loadDetail(){
        String token = SessionUtils.get(this.context, DataStatic.SESSION.KEY.AUTH, "");
        this.context.getHomeViewModel().getDetail(token, this.travel.getId()).observe(context, res -> {
            if(res.getResult() != null){
                this.travel = res.getResult();
                this.tvName.setText(this.travel.getName());
                this.tvTotalView.setText(this.travel.getTotalView().toString());
                this.tvTotalLike.setText(this.travel.getTotalLike().toString());
                this.tvDesc.setText(this.travel.getDescription());
                this.tvRatePoint.setText(this.travel.getRatePoint().toString());
            }
        });
    }

    public void loadHotel(){
        this.adapterTravelHotel.setTravel(this.travel);
        this.context.getHomeViewModel().getHotelByTravel(this.travel.getId()).observe(context, res -> {
            if(res.getResult() != null && res.getResult().size() > 0){
                this.listHotel.clear();
                this.listHotel.addAll(res.getResult());
                this.adapterTravelHotel.notifyDataSetChanged();
            }
        });
    }

    public void loadComment(){

        this.context.getHomeViewModel().getCommentByTravel(this.travel).observe(context, res -> {
            if(res.getResult() != null && res.getResult().size() > 0){
                this.listComment.clear();
                this.listComment.addAll(res.getResult());
                this.adapterComment.notifyDataSetChanged();
            }
        });
    }

    public void loadTravelMeta(){

        this.context.getHomeViewModel().getMetas(this.travel.getId()).observe(context, res -> {
            if(res.getResult() != null && res.getResult().size() > 0){
                this.listTravelMeta.clear();
                this.listTravelMeta.addAll(res.getResult());
                this.adapterTravelMeta.notifyDataSetChanged();
            }
        });
    }

    public void actionView(){
        this.btnGoMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: call map
                String strGeoLocation = travel.getLat().toString().concat(",").concat(travel.getLon().toString());
//                Uri.parse("http://maps.google.com/maps?saddr=20.344,34.34&daddr=20.5666,45.345"));
                System.out.println(strGeoLocation);
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?daddr=".concat(strGeoLocation)));
                context.startActivity(intent);
            }
        });

        this.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        this.btnSendCmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strCmt = etCmt.getText().toString();
                if(strCmt.length() > 0){
                    String token = SessionUtils.get(context, DataStatic.SESSION.KEY.AUTH, "");
                    Comment comment = new Comment(travel.getId(), strCmt);
                    etCmt.setText("");
                    View v = context.getCurrentFocus();
                    if (v != null) {
                        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    }

                    context.getHomeViewModel().postComment(token, comment).observe(context, res -> {
                        if(res.getResult() != null){
                            loadComment();
                        }
                    });
                }
            }
        });
    }
}
