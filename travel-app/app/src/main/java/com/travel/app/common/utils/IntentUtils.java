package com.travel.app.common.utils;

import android.app.Activity;
import android.content.Intent;

import com.travel.app.common.DataStatic;

public class IntentUtils {

    public static class FRAGMENT {
        public static final String HOME = "fragment_home";
        public static final String TRAVEL_DETAIL = "fragment_travel_detail";
        public static final String HOTEL_DETAIL = "fragment_hotel_detail";
    }

    public static class KEY {
        public static final String FRAGMENT = "fragment";
        public static final String FLAG = "flag";
    }

    public static void chooseImage(Activity context, String fragment){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra(KEY.FRAGMENT, fragment);
        context.startActivityForResult(Intent.createChooser(intent, "Select Picture"), DataStatic.CODE.CHOOSE_IMAGE);
    }

}
