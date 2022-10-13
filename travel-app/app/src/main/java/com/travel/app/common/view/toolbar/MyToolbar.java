package com.travel.app.common.view.toolbar;

import android.app.Activity;

import com.travel.app.R;
import com.travel.app.common.view.icon.TextViewAwsSo;

public class MyToolbar {
    private Activity activity;
    private TextViewAwsSo twaMenuMore, twaBtnBack;

    public MyToolbar(Activity activity){
        this.activity = activity;
        this.init();
    }

    private void init(){
        this.twaMenuMore = this.activity.findViewById(R.id.twa_menumore);
        this.twaBtnBack = this.activity.findViewById(R.id.twa_btn_back);
    }

    public TextViewAwsSo getTwaMenuMore(){
        return this.twaMenuMore;
    }

    public TextViewAwsSo getTwaBtnBack(){
        return this.twaBtnBack;
    }
}
