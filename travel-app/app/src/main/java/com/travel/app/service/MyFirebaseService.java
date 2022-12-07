package com.travel.app.service;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.travel.app.AuthActivity;
import com.travel.app.MainActivity;
import com.travel.app.common.DataStatic;
import com.travel.app.common.utils.SessionUtils;

public class MyFirebaseService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if(remoteMessage.getNotification() != null){
            Log.d(TAG, "onMessageReceived[access_token]: "+remoteMessage.getData().get("accessToken"));
            if(remoteMessage.getData().get("accessToken") != null){
                SessionUtils.set(getApplicationContext(), DataStatic.SESSION.KEY.AUTH, remoteMessage.getData().get("accessToken"));
                SessionUtils.set(getApplicationContext(), DataStatic.SESSION.KEY.AUTH_BEFORE, remoteMessage.getData().get("accessToken"));
                Intent i = new Intent(this, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }else{

            }
        }
    }
}
