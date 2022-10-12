package com.travel.app.view.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.travel.app.R;
import com.travel.app.data.model.Travel;

import java.util.List;

public class AdapterTravel extends RecyclerView.Adapter<AdapterTravel.ViewHolder> {

    private Activity context;
    private List<Travel> travels;
    private static final Integer RES_ID = R.layout.item_travel;

    public AdapterTravel(Activity context, List<Travel> travels) {
        this.context = context;
        this.travels = travels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(RES_ID, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Travel travel = travels.get(position);
        holder.loadDataToView(travel);
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

        public void loadDataToView(Travel travel){

        }
    }
}
