package com.travel.app.view.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.travel.app.MainActivity;
import com.travel.app.R;
import com.travel.app.common.view.icon.TextViewAwsSo;
import com.travel.app.data.model.Location;
import com.travel.app.data.model.Travel;
import com.travel.app.view.adapter.AdapterTravel;

import java.util.ArrayList;
import java.util.List;

@SuppressLint({"ValidFragment", "NotifyDataSetChanged"})
public class FragmentMainTravelSearch extends Fragment {

    private static final Integer RES_ID = R.layout.fragment_main_travel_search;
    private MainActivity context;
    private View view;
    private RecyclerView rvTravel;
    private EditText etSearch;
    private TextViewAwsSo btnSearch;

    private AdapterTravel adapterTravel;
    private List<Travel> listTravel;
    private String searchText = "";

    public FragmentMainTravelSearch(MainActivity mContext){
        this.context = mContext;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(RES_ID, container, false);
        //init view
        this.init();
        this.actionView();
        loadTravel();
        return this.view;
    }

    public void init(){
        this.listTravel = new ArrayList<>();
        this.rvTravel = this.view.findViewById(R.id.rv_travel);
        this.adapterTravel = new AdapterTravel(this.context, this.listTravel);
        this.rvTravel.setAdapter(this.adapterTravel);
        this.rvTravel.setLayoutManager(new LinearLayoutManager(context));
        this.etSearch = this.view.findViewById(R.id.et_search);
        this.btnSearch = this.view.findViewById(R.id.btn_search);

    }

    public void loadTravel(){
        this.context.getHomeViewModel().getTravelList(searchText).observe(context, res -> {
            this.listTravel.clear();
            if(res.getResult() != null && res.getResult().size() > 0){
                this.listTravel.addAll(res.getResult());
            }
            this.adapterTravel.notifyDataSetChanged();
        });
    }

    public void actionView(){
        this.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, listTravel.size()+"", Toast.LENGTH_SHORT).show();
                searchText = etSearch.getText().toString().trim();
                loadTravel();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
