package com.travel.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.travel.app.common.DataStatic;
import com.travel.app.common.utils.SessionUtils;
import com.travel.app.data.model.User;
import com.travel.app.viewmodel.HomeViewModel;
import com.travel.app.viewmodel.ProfileViewModel;

public class ProfileActivity extends AppCompatActivity {

    private ProfileViewModel profileViewModel;
    private EditText etUsername, etPassword, etFullname, etPhone, etMail;
    private Button btnUpdate;
    String token = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        init();
        initData();
        actionView();
    }

    private void init(){
        this.profileViewModel = ViewModelProviders.of(this).get(ProfileViewModel.class);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        etFullname = findViewById(R.id.et_full_name);
        etPhone = findViewById(R.id.et_phone);
        etMail = findViewById(R.id.et_mail);
        btnUpdate = findViewById(R.id.btn_update);
        token = SessionUtils.get(this, DataStatic.SESSION.KEY.AUTH, "");
    }

    private void initData(){
        this.profileViewModel.info(token).observe(this, res -> {
            if(res.getResult() != null && res.getResult().getId() != null){
                User userInfo = res.getResult();
                etUsername.setText(userInfo.getUsername());
                etFullname.setText(userInfo.getFullName());
                etPhone.setText(userInfo.getPhone());
                etMail.setText(userInfo.getEmail());
            }
        });
    }

    private void actionView(){
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setFullName(etFullname.getText().toString());
                user.setEmail(etMail.getText().toString());
                user.setPhone(etPhone.getText().toString());
                if(etPassword.getText().toString().trim().length() > 0){
                    user.setPassword(etPassword.getText().toString());
                }
                profileViewModel.update(token, user).observe(ProfileActivity.this, res ->{
                    Toast.makeText(ProfileActivity.this, res.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }
        });
    }
}