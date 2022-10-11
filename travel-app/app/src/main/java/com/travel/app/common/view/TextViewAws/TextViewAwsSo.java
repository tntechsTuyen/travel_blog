package com.travel.app.common.view.TextViewAws;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class TextViewAwsSo extends AppCompatTextView {
    public TextViewAwsSo(Context context) {
        super(context);
        init();
    }

    public TextViewAwsSo(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewAwsSo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        Typeface typeface = Typeface.createFromAsset( getContext().getAssets(), "fonts/fa-solid-900.ttf" );
        setTypeface(typeface);
    }
}
