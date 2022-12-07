package com.travel.app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.iid.FirebaseInstanceId;

public class TestActivity extends AppCompatActivity {
    private String TAG = "TestActivity";
    EditText etContent;
    Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        init();
        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(this, instanceIdResult ->{
            Log.i(TAG, "Device token id: "+instanceIdResult.getToken());
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("CheckResult")
            @Override
            public void onClick(View view) {
            }
        });
    }

    private void init(){
        etContent = findViewById(R.id.et_content);
        btnSend = findViewById(R.id.btn_send);
    }

}