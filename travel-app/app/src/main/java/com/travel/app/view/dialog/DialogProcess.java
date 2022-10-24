package com.travel.app.view.dialog;

import android.app.Activity;
import android.app.ProgressDialog;

public class DialogProcess {

    private ProgressDialog dialog;

    public DialogProcess(Activity activity){
        this.dialog = new ProgressDialog(activity);
    }

    public void show(){
        this.dialog.show();
    }

    public void hide(){
        this.dialog.dismiss();
    }
}
