package com.travel.app.common.utils;

import android.app.Activity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.travel.app.R;
import com.travel.app.common.DataStatic;

public class ImageUtils {

    public static void loadUrl(Activity context, ImageView imv, String url) {
        if (url != null && url.length() > 0) {
            url = String.format("%s%s", DataStatic.BASE_URL, url);
            Glide.with(context)
                    .load(url)
                    .thumbnail(0.2f)
                    .dontAnimate()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .into(imv);
        }else{
            Glide.with(context)
                    .load(R.drawable.no_image)
                    .thumbnail(0.2f)
                    .dontAnimate()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .into(imv);
        }
    }

}
