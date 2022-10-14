package com.travel.app.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.travel.app.AuthActivity;
import com.travel.app.R;
import com.travel.app.common.DataStatic;
import com.travel.app.common.utils.SessionUtils;

public class DialogMainMenu {

    private Activity context;
    private Dialog dialog;
    private Button btnSearch, btnTagSetup, btnSignIn, btnSignOut;

    public DialogMainMenu(Activity context){
        this.context = context;
        this.dialog = new Dialog(context);
        this.dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.dialog.setContentView(R.layout.dialog_main_menu);
        this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        this.init();
        this.actionView();
    }

    private void init(){
        this.btnSearch = this.dialog.findViewById(R.id.btn_search);
        this.btnTagSetup = this.dialog.findViewById(R.id.btn_tag_setup);
        this.btnSignIn = this.dialog.findViewById(R.id.btn_sign_in);
        this.btnSignOut = this.dialog.findViewById(R.id.btn_sign_out);
    }

    private void actionView(){
        this.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, AuthActivity.class));
                hide();
            }
        });
        this.btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SessionUtils.remove(context, DataStatic.SESSION.KEY.AUTH);
                updateViewAuth();
                Toast.makeText(context, "Bạn đã đăng xuất khỏi hệ thống", Toast.LENGTH_SHORT).show();
                context.getFragmentManager().popBackStack();
                hide();
            }
        });
    }

    public void show(){
        this.dialog.show();
    }

    public void hide(){
        this.dialog.dismiss();
    }

    public void updateViewAuth(){
        String auth = SessionUtils.get(context, DataStatic.SESSION.KEY.AUTH, "");
        if(auth != null && auth.trim().length() > 0){
            this.btnTagSetup.setVisibility(View.VISIBLE);
            this.btnSignOut.setVisibility(View.VISIBLE);
            this.btnSignIn.setVisibility(View.GONE);
        }else{
            this.btnTagSetup.setVisibility(View.GONE);
            this.btnSignOut.setVisibility(View.GONE);
            this.btnSignIn.setVisibility(View.VISIBLE);
        }
    }
}
