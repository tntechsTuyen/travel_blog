package com.travel.app.view.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.travel.app.MainActivity;
import com.travel.app.R;
import com.travel.app.data.model.Travel;

import java.util.List;

public class AdapterTravelCity extends RecyclerView.Adapter<AdapterTravelCity.ViewHolder> {

    private MainActivity context;
    private List<String> travels;
    private static final Integer RES_ID = R.layout.item_travel_city;

    public AdapterTravelCity(MainActivity context, List<String> travels) {
        this.context = context;
        this.travels = travels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(RES_ID, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.setFragmentMainTravelCity();
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return travels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void init(){}

        public void loadDataToView(){

        }
    }
}
