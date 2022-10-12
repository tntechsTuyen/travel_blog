package com.travel.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.travel.app.data.model.User;
import com.travel.app.view.fragment.FragmentMainHome;
import com.travel.app.view.fragment.FragmentSignIn;
import com.travel.app.viewmodel.MainViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private MainViewModel mainViewModel;
    private Button btnLogin;
    private FragmentMainHome fragmentMainHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.init();
        this.actionView();
        this.setFragmentMainHome();
    }

    private void init(){
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        this.btnLogin = findViewById(R.id.btn_login);
        getTravel();
    }

    private void actionView(){
        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AuthActivity.class));
            }
        });
    }

    private void getTravel(){

        mainViewModel.getTravelRepositoryLiveData().observe(this, data -> {
            System.out.println("--------------------------------------------------------------: ");
            for(int i = 0; i < data.size(); i++){
                Log.i(TAG, data.get(i).toString());
            }
        });
    }

    private void setFragmentMainHome(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if(fragmentMainHome == null){
            fragmentMainHome = new FragmentMainHome(MainActivity.this);
        }
        transaction.replace(R.id.layout_content, fragmentMainHome).commitAllowingStateLoss();
    }
}