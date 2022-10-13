package com.travel.app.common.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

import com.google.gson.Gson;
import com.travel.app.common.DataStatic;

public class SessionUtils {

    public static void set(Context context, String key, Object obj){

        SharedPreferences sp = context.getSharedPreferences(DataStatic.SESSION.NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, new Gson().toJson(obj));
        editor.apply();
    }

    public static String get(Context context, String key, String def){

        if(def == null) def = "{}";
        SharedPreferences sp = context.getSharedPreferences(DataStatic.SESSION.NAME, MODE_PRIVATE);
        return sp.getString(key, def);
    }

    public static void remove(Context context, String key){

        SharedPreferences sp = context.getSharedPreferences(DataStatic.SESSION.NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.apply();
    }
}
