package com.travel.app.common.view.icon;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import com.travel.app.R;

@SuppressLint("NewApi")
public class TextViewAwsBra extends AppCompatTextView {
    public TextViewAwsBra(Context context) {
        super(context);
        init();
    }

    public TextViewAwsBra(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewAwsBra(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
//        Typeface typeface = Typeface.createFromAsset( getContext().getAssets(), "fonts/fa-brands-400.ttf" );
        Typeface typeface = getResources().getFont(R.font.fa_brands);
        setTypeface(typeface);
    }
}
