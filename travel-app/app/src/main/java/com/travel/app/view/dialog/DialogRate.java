package com.travel.app.view.dialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.travel.app.AuthActivity;
import com.travel.app.MainActivity;
import com.travel.app.R;
import com.travel.app.common.DataStatic;
import com.travel.app.common.utils.SessionUtils;
import com.travel.app.common.view.icon.TextViewAwsRe;
import com.travel.app.data.model.PostUser;
import com.travel.app.viewmodel.HomeViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressLint("NewApi")
public class DialogRate {

    private MainActivity context;
    private Dialog dialog;
    private TextViewAwsRe twaStar1,twaStar2,twaStar3,twaStar4,twaStar5;
    private Button btnSubmit;
    private List<TextViewAwsRe> lstStar = new ArrayList<>(), lstContextStar;
    private HomeViewModel homeViewModel;
    private Integer idPost, rateVal = 0;

    public DialogRate(MainActivity context, Integer idPost, HomeViewModel homeViewModel, List<TextViewAwsRe> contextStar){
        this.context = context;
        this.homeViewModel = homeViewModel;
        this.lstContextStar = contextStar;
        this.idPost = idPost;
        this.dialog = new Dialog(context);
        this.dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.dialog.setContentView(R.layout.dialog_post_rate);
        this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        this.init();
        this.actionView();
    }

    private void init(){
        this.twaStar1 = this.dialog.findViewById(R.id.twa_star_1);
        this.twaStar2 = this.dialog.findViewById(R.id.twa_star_2);
        this.twaStar3 = this.dialog.findViewById(R.id.twa_star_3);
        this.twaStar4 = this.dialog.findViewById(R.id.twa_star_4);
        this.twaStar5 = this.dialog.findViewById(R.id.twa_star_5);
        this.btnSubmit = this.dialog.findViewById(R.id.btn_submit);
        lstStar.add(twaStar1);
        lstStar.add(twaStar2);
        lstStar.add(twaStar3);
        lstStar.add(twaStar4);
        lstStar.add(twaStar5);
    }

    private void actionView(){

        for(int i = 0; i < lstStar.size(); i++){
            int finalI = i;
            lstStar.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changeRate(finalI);
                }
            });
        }

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String token = SessionUtils.get(context, DataStatic.SESSION.KEY.AUTH, "");
                PostUser postUser = new PostUser(idPost, rateVal);
                homeViewModel.postRate(token, postUser).observe(context, res->{
                    changeRateContext(res.getResult().getRate());
                    Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show();
                });
                hide();
            }
        });
    }

    private void changeRate(Integer r){
        rateVal = r + 1;
        Typeface typeface = context.getResources().getFont(R.font.fa_regular);
        for(int i = 0 ; i < lstStar.size(); i++){
            lstStar.get(i).setTypeface(typeface);
        }

        typeface = context.getResources().getFont(R.font.fa_solid);
        for(int i = 0; i <= r; i++){
            lstStar.get(i).setTypeface(typeface);
        }
    }

    private void changeRateContext(Integer r){
        Typeface typeface = context.getResources().getFont(R.font.fa_regular);
        for(int i = 0 ; i < lstContextStar.size(); i++){
            lstContextStar.get(i).setTypeface(typeface);
        }

        typeface = context.getResources().getFont(R.font.fa_solid);
        for(int i = 0; i < r; i++){
            lstContextStar.get(i).setTypeface(typeface);
        }
    }

    public void show(){
        this.dialog.show();
    }

    public void hide(){
        this.dialog.dismiss();
    }

}
