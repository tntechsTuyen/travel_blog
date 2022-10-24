package com.travel.app.view.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.travel.app.MainActivity;
import com.travel.app.R;
import com.travel.app.common.DataStatic;
import com.travel.app.common.utils.ImageUtils;
import com.travel.app.common.utils.IntentUtils;
import com.travel.app.common.utils.PermissionUtils;
import com.travel.app.common.utils.SessionUtils;
import com.travel.app.common.utils.UriUtils;
import com.travel.app.common.view.icon.TextViewAwsRe;
import com.travel.app.common.view.icon.TextViewAwsSo;
import com.travel.app.data.model.Comment;
import com.travel.app.data.model.Hotel;
import com.travel.app.data.model.HotelMeta;
import com.travel.app.data.model.Media;
import com.travel.app.data.model.PostUser;
import com.travel.app.view.adapter.AdapterComment;
import com.travel.app.view.adapter.AdapterHotelMeta;
import com.travel.app.view.dialog.DialogRate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

@SuppressLint({"ValidFragment","NewApi"})
public class FragmentMainHotelDetail extends Fragment {

    private static final Integer RES_ID = R.layout.fragment_main_hotel_detail;
    private MainActivity context;
    private View view;
    private Group grAuth;
    private RecyclerView rvComment, rvHotelMeta;
    private ImageView ivThumb;
    private TextView tvName, tvTotalView, tvTotalLike, tvRatePoint, tvRateCount, tvPhone, tvWork, tvAttachFile, btnGoMap;
    private TextViewAwsRe twaStar1,twaStar2,twaStar3,twaStar4,twaStar5;
    private List<TextViewAwsRe> lstStar = new ArrayList<>();
    private LinearLayout llRateView, llAttachFile;
    private TextViewAwsSo btnSendCmt, btnFile, twaBtnRemoveAttachFile;
    private EditText etCmt;
    private TextViewAwsRe btnLike;
    private AdapterComment adapterComment;
    private AdapterHotelMeta adapterHotelMeta;
    private List<Comment> listComment = new ArrayList<>();
    private List<HotelMeta> listHotelMeta = new ArrayList<>();
    private Hotel hotel;
    private Comment commentReply;

    @SuppressLint("ValidFragment")
    public FragmentMainHotelDetail(MainActivity mContext, Hotel hotel){
        this.context = mContext;
        this.hotel = hotel;
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

        this.rvHotelMeta = this.view.findViewById(R.id.rv_hotel_meta);
        this.adapterHotelMeta = new AdapterHotelMeta(this.context, this.listHotelMeta);
        this.rvHotelMeta.setAdapter(this.adapterHotelMeta);
        this.rvHotelMeta.setLayoutManager(new LinearLayoutManager(context));

        this.rvComment = this.view.findViewById(R.id.rv_comment);
        this.adapterComment = new AdapterComment(this.context, this.listComment, this);
        this.rvComment.setAdapter(this.adapterComment);
        this.rvComment.setLayoutManager(new LinearLayoutManager(context));

        this.ivThumb = this.view.findViewById(R.id.iv_thumb);
        this.tvName = this.view.findViewById(R.id.tv_name);
        this.tvTotalView = this.view.findViewById(R.id.tv_total_view);
        this.tvTotalLike = this.view.findViewById(R.id.tv_total_like);
        this.tvRatePoint = this.view.findViewById(R.id.tv_rate_point);
        this.tvRateCount = this.view.findViewById(R.id.tv_rate_count);
        this.tvAttachFile = this.view.findViewById(R.id.tv_attach_file);
        this.btnGoMap = this.view.findViewById(R.id.btn_go_map);
        this.btnLike = this.view.findViewById(R.id.btn_like);
        this.etCmt = this.view.findViewById(R.id.et_cmt);
        this.btnSendCmt = this.view.findViewById(R.id.btn_send_cmt);
        this.btnFile = this.view.findViewById(R.id.btn_file);
        this.tvPhone = this.view.findViewById(R.id.tv_phone);
        this.tvWork = this.view.findViewById(R.id.tv_work);
        this.llAttachFile = this.view.findViewById(R.id.ll_attach_file);
        this.twaBtnRemoveAttachFile = this.view.findViewById(R.id.twa_btn_remove_attach_file);
        this.grAuth = this.view.findViewById(R.id.gr_auth);
        this.llRateView = this.view.findViewById(R.id.ll_rate_view);
        initStar();
    }

    private void initStar(){
        this.twaStar1 = this.view.findViewById(R.id.twa_star_1);
        this.twaStar2 = this.view.findViewById(R.id.twa_star_2);
        this.twaStar3 = this.view.findViewById(R.id.twa_star_3);
        this.twaStar4 = this.view.findViewById(R.id.twa_star_4);
        this.twaStar5 = this.view.findViewById(R.id.twa_star_5);
        lstStar.add(twaStar1);
        lstStar.add(twaStar2);
        lstStar.add(twaStar3);
        lstStar.add(twaStar4);
        lstStar.add(twaStar5);
    }

    @Override
    public void onResume() {
        super.onResume();
        String token = SessionUtils.get(this.context, DataStatic.SESSION.KEY.AUTH, "");
        this.context.setFragmentTarget(this);
        if(token != null && token.trim().length() > 0){
            this.grAuth.setVisibility(View.VISIBLE);
        }else{
            this.grAuth.setVisibility(View.GONE);
        }
        loadData();
    }

    private void loadData(){
        loadDetail();
    }

    private void loadDetail(){
        String token = SessionUtils.get(this.context, DataStatic.SESSION.KEY.AUTH, "");
        this.context.getHomeViewModel().getHotelDetail(token, this.hotel.getId()).observe(context, res -> {
            if(res.getResult() != null){
                this.hotel = res.getResult();
                this.hotel.setIdPost(this.hotel.getIdPost());
                this.tvName.setText(this.hotel.getName());
                this.tvTotalView.setText(hotel.getTotalView().toString());
                this.tvTotalLike.setText(hotel.getTotalLike().toString());
                this.tvRatePoint.setText(hotel.getRatePoint().toString());
                this.tvRateCount.setText(hotel.getRateCount().equals(0) ? "" : String.format("(%d)", hotel.getRateCount()));
                ImageUtils.loadUrl(context, this.ivThumb, hotel.getMediaUrl());
                if(this.hotel.getIsLike() != null && this.hotel.getIsLike() == 1) {
                    Typeface typeface = context.getResources().getFont(R.font.fa_solid);
                    this.btnLike.setTypeface(typeface);
                }
                this.tvPhone.setText(res.getResult().getPhone());
                this.tvWork.setText(res.getResult().getWork());
                loadStar();
                loadHotelMeta();
                loadComment();
            }
        });
    }

    public void loadStar(){
        Typeface typeface = context.getResources().getFont(R.font.fa_solid);
        if(hotel.getRate() != null && hotel.getRate() > 0){
            Integer rb = this.hotel.getRate();
            for(int i = 0; i < rb; i++){
                lstStar.get(i).setTypeface(typeface);
            }
        }
    }

    public void loadComment(){
        this.context.getHomeViewModel().getComment(this.hotel.getIdPost()).observe(context, res -> {
            this.listComment.clear();
            if(res.getResult() != null && res.getResult().size() > 0){
                this.listComment.addAll(res.getResult());
            }
            this.adapterComment.notifyDataSetChanged();
        });
    }

    public void loadHotelMeta(){

        this.context.getHomeViewModel().getHotelMeta(this.hotel.getId()).observe(context, res -> {
            this.listHotelMeta.clear();
            if(res.getResult() != null && res.getResult().size() > 0){
                this.listHotelMeta.addAll(res.getResult());
            }
            this.adapterHotelMeta.notifyDataSetChanged();
        });
    }

    public void actionView(){
        this.btnGoMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: call map
                String strGeoLocation = hotel.getLat().toString().concat(",").concat(hotel.getLon().toString());
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
                String token = SessionUtils.get(context, DataStatic.SESSION.KEY.AUTH, "");
                PostUser postUser = new PostUser();
                postUser.setIdPost(hotel.getIdPost());
                postUser.setIsLike(1);
                context.getHomeViewModel().postLike(token, postUser).observe(context, res -> {
                    Log.i("POST_LIKE", res.getResult().toString());
                    Integer isLike =  res.getResult().getIsLike();
                    Integer val;
                    Typeface typeface;
                    switch (isLike){
                        case 1:
                            typeface = context.getResources().getFont(R.font.fa_solid);
                            val = 1;
                            Toast.makeText(context, "Like post", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            typeface = context.getResources().getFont(R.font.fa_regular);
                            val = -1;
                            Toast.makeText(context, "Unlike post", Toast.LENGTH_SHORT).show();
                            break;
                    }
                    tvTotalLike.setText(String.format("%d", hotel.getTotalLike() + val));
                    btnLike.setTypeface(typeface);
                });
            }
        });

        this.btnSendCmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strCmt = etCmt.getText().toString().trim();
                String strAttach = tvAttachFile.getText().toString().trim();
                String token = SessionUtils.get(context, DataStatic.SESSION.KEY.AUTH, "");
                if(strCmt.length() == 0) return;
                postComment(token, strCmt, strAttach);
            }
        });

        this.llRateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String token = SessionUtils.get(context, DataStatic.SESSION.KEY.AUTH, "");
                if(token.length() != 0){
                    new DialogRate(context, hotel.getIdPost(), context.getHomeViewModel(), lstStar).show();
                }
            }
        });

        this.btnFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(PermissionUtils.readExternalStorage(context)){
                    IntentUtils.chooseImage(context, IntentUtils.FRAGMENT.TRAVEL_DETAIL);
                }
            }
        });

        this.twaBtnRemoveAttachFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvAttachFile.setText("");
                llAttachFile.setVisibility(View.GONE);
            }
        });
    }

    public void postComment(String token, String strCmt, String pathFile){
        if(strCmt.length() > 0){
            Comment comment = new Comment(hotel.getIdPost(), strCmt);
            if(commentReply != null){
                comment.setIdParent(commentReply.getId());
            }
            etCmt.setText("");
            tvAttachFile.setText("");
            llAttachFile.setVisibility(View.GONE);
            View v = context.getCurrentFocus();
            if (v != null) {
                InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
            context.getHomeViewModel().postComment(token, comment, pathFile, this);

        }
    }

    public void setCommentReply(Comment commentReply) {
        this.commentReply = commentReply;
        String cmt = etCmt.getText().toString();
        if(cmt.contains("@")){
            String cmtArr[] = cmt.split(" ");
            cmtArr[0] = String.format("@%s", this.commentReply.getUsername(), cmt);
            etCmt.setText(cmtArr.toString());
        }else{
            etCmt.setText(String.format("@%s %s", this.commentReply.getUsername(), cmt));
        }
    }

    public void setAttachFile(String path){
        this.llAttachFile.setVisibility(View.VISIBLE);
        this.tvAttachFile.setText(path);
    }
}
