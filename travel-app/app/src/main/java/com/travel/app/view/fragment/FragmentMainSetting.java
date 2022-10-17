package com.travel.app.view.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.travel.app.MainActivity;
import com.travel.app.R;
import com.travel.app.common.DataStatic;
import com.travel.app.common.utils.SessionUtils;
import com.travel.app.common.view.icon.TextViewAwsSo;
import com.travel.app.data.model.Tag;
import com.travel.app.data.model.Travel;
import com.travel.app.view.adapter.AdapterSettingTag;
import com.travel.app.view.adapter.AdapterTravel;

import java.util.ArrayList;
import java.util.List;

@SuppressLint({"ValidFragment", "NotifyDataSetChanged"})
public class FragmentMainSetting extends Fragment {

    private static final Integer RES_ID = R.layout.fragment_main_setting;
    private MainActivity context;
    private View view;
    private RecyclerView rvTag;
    private Button btnUpdate;

    private AdapterSettingTag adapterSettingTag;
    private List<Tag> listTag;

    public FragmentMainSetting(MainActivity mContext){
        this.context = mContext;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(RES_ID, container, false);
        //init view
        this.init();
        this.actionView();
        this.loadTag();
        return this.view;
    }

    public void init(){
        this.listTag = new ArrayList<>();
        this.rvTag = this.view.findViewById(R.id.rv_tag);
        this.adapterSettingTag = new AdapterSettingTag(this.context, this.listTag);
        this.rvTag.setAdapter(this.adapterSettingTag);
        this.rvTag.setLayoutManager(new LinearLayoutManager(context));

        this.btnUpdate = this.view.findViewById(R.id.btn_update);
    }

    public void loadTag(){
        String token = SessionUtils.get(this.context, DataStatic.SESSION.KEY.AUTH, "");
        this.context.getHomeViewModel().getTagList(token).observe(context, res -> {
            this.listTag.clear();
            if(res.getResult() != null && res.getResult().size() > 0){
                this.listTag.addAll(res.getResult());
            }
            this.adapterSettingTag.notifyDataSetChanged();
        });
    }

    public void actionView(){
        this.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String token = SessionUtils.get(context, DataStatic.SESSION.KEY.AUTH, "");
                context.getHomeViewModel().postTagUpdate(token, adapterSettingTag.getLstIdChecked()).observe(context, res->{
                    if(res.getResult()){
                        Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
