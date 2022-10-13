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

import com.travel.app.AuthActivity;
import com.travel.app.R;

public class DialogMainMenu {

    private Activity context;
    private Dialog dialog;
    private Button btnSearch, btnTagSetup, btnSignIn;

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
    }

    private void actionView(){
        this.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, AuthActivity.class));
            }
        });
    }

    public void show(){
        this.dialog.show();
    }

    public void hide(){
        this.dialog.dismiss();
    }
}
