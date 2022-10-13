package com.travel.app;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.travel.app.common.DataStatic;
import com.travel.app.common.view.icon.TextViewAwsSo;
import com.travel.app.view.fragment.FragmentSignIn;
import com.travel.app.view.fragment.FragmentSignUp;

public class AuthActivity extends AppCompatActivity {

    private FragmentSignIn fragmentSignIn;
    private FragmentSignUp fragmentSignUp;
    private TextViewAwsSo twaBtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        this.init();
        this.actionView();

        setFragmentSignIn();
    }

    private void init(){
        this.twaBtnBack = findViewById(R.id.twa_btn_back);
    }

    private void actionView(){
        this.twaBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    public void setFragmentSignIn(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if(fragmentSignIn == null){
            fragmentSignIn = new FragmentSignIn(AuthActivity.this);
        }
        transaction.replace(R.id.layout_content, fragmentSignIn);
        transaction.commitAllowingStateLoss();
    }

    public void setFragmentSignUp(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if(fragmentSignUp == null){
            fragmentSignUp = new FragmentSignUp(AuthActivity.this);
        }
        transaction.replace(R.id.layout_content, fragmentSignUp).addToBackStack(DataStatic.STACK_APP);
        transaction.commitAllowingStateLoss();
    }
}