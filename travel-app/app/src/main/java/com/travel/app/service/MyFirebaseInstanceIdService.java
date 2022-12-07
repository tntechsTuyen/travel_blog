package com.travel.app.service;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.travel.app.common.DataStatic;
import com.travel.app.common.utils.SessionUtils;

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {
    private static final String TAG = "MyFirebaseService";

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        SessionUtils.set(this, DataStatic.SESSION.KEY.DEVICE_ID, refreshedToken);
        Log.d(TAG, "Refreshed token: " + refreshedToken);
    }
}
