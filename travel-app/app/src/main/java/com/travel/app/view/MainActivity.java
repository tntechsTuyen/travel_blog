package com.travel.app.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.travel.app.R;
import com.travel.app.data.model.Travel;
import com.travel.app.data.model.User;
import com.travel.app.viewmodel.MainViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ArrayList<User> lstUser = new ArrayList<>();
    private MainViewModel mainViewModel;

    private WebView wvMain;
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        getTravel();
    }

    private void getTravel(){

        mainViewModel.getTravelRepositoryLiveData().observe(this, data -> {
            System.out.println("--------------------------------------------------------------: ");
            for(int i = 0; i < data.size(); i++){
                Log.i(TAG, data.get(i).toString());
            }
        });
    }
}