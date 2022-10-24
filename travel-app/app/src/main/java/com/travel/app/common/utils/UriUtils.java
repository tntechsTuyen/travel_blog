package com.travel.app.common.utils;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;

public class UriUtils {

    public static String getRealPath(Activity context, Uri uri){
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = context.getContentResolver().query(uri, filePathColumn, null, null, null);
        if(cursor.moveToFirst()){
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            return cursor.getString(columnIndex);
        } else {
            //boooo, cursor doesn't have rows ...
        }
        cursor.close();
        return "";
    }
}
