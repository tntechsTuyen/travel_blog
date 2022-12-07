package com.travel.app.view.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;

import com.travel.app.AuthActivity;
import com.travel.app.R;
import com.travel.app.common.DataStatic;
import com.travel.app.common.response.ApiResponse;
import com.travel.app.common.utils.SessionUtils;
import com.travel.app.data.model.User;

import java.util.concurrent.Executor;

@SuppressLint("ValidFragment")
public class FragmentSignIn extends Fragment {

    private static final Integer RES_ID = R.layout.fragment_sign_in;
    private AuthActivity context;
    private View view;

    private EditText etUsername, etPassword;
    private Button btnLogin, btnRegister;
    private ImageView ivFingerPrint;
    private BiometricManager biometricManager;

    @SuppressLint("ValidFragment")
    public FragmentSignIn(AuthActivity mContext){
        this.context = mContext;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(RES_ID, container, false);
        //init view
        this.init();
        this.initBiometric();
        this.actionView();
        return this.view;
    }

    public void init(){
        this.etUsername = this.view.findViewById(R.id.et_username);
        this.etPassword = this.view.findViewById(R.id.et_password);
        this.btnLogin = this.view.findViewById(R.id.btn_login);
        this.btnRegister = this.view.findViewById(R.id.btn_register);
        this.ivFingerPrint = this.view.findViewById(R.id.iv_fingerprint);

        boolean isFingerPrint = SessionUtils.get(getActivity(), DataStatic.SESSION.KEY.FINGER_PRINT, false);
        if(!isFingerPrint) this.ivFingerPrint.setVisibility(View.GONE);
    }

    private void initBiometric(){
        String authBefore = SessionUtils.get(context, DataStatic.SESSION.KEY.AUTH_BEFORE, "");
        if(authBefore.trim().length() == 0) ivFingerPrint.setVisibility(View.GONE);
        biometricManager = androidx.biometric.BiometricManager.from(context);
        switch (biometricManager.canAuthenticate()) {
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                ivFingerPrint.setVisibility(View.GONE);
                break;
        }
        Executor executor = ContextCompat.getMainExecutor(context);
        BiometricPrompt biometricPrompt = new BiometricPrompt(context, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                SessionUtils.set(context, DataStatic.SESSION.KEY.AUTH, authBefore);
                Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show();
                context.finish();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        });
        BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder().setTitle("GFG")
                .setDescription("Use your fingerprint to login ").setNegativeButtonText("Cancel").build();
        ivFingerPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                biometricPrompt.authenticate(promptInfo);
            }
        });
    }

    public void actionView(){
        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog pd = new ProgressDialog(getActivity());
                pd.setMessage("Waiting");
                pd.show();

                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String deviceId = SessionUtils.get(getActivity(), DataStatic.SESSION.KEY.DEVICE_ID, "");
                if(username.length() == 0 || password.length() == 0 || deviceId.length() == 0){
                    Toast.makeText(context, "Username and password not empty", Toast.LENGTH_SHORT).show();
                    pd.dismiss();
                }else{
                    //TODO: Request login auth
                    LiveData<ApiResponse<String>> lvData = context.getAuthViewModel().login(new User(username, password, deviceId));
                    lvData.observe(context, data -> {
                        Toast.makeText(context, data.getMessage(), Toast.LENGTH_SHORT).show();
                        if(data.getStatus() == DataStatic.HttpStatus.SUCCESS){
                            pd.setMessage("Please checking mail verify");
                        }
                    });

                }
            }
        });

        this.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.setFragmentSignUp();
            }
        });
    }
}
