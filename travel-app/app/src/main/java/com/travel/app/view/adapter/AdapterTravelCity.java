package com.travel.app.view.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.travel.app.MainActivity;
import com.travel.app.R;
import com.travel.app.data.model.Location;
import com.travel.app.data.model.Travel;

import java.util.List;

public class AdapterTravelCity extends RecyclerView.Adapter<AdapterTravelCity.ViewHolder> {

    private MainActivity context;
    private List<Location> locations;
    private static final Integer RES_ID = R.layout.item_travel_city;

    public AdapterTravelCity(MainActivity context, List<Location> locations) {
        this.context = context;
        this.locations = locations;
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
        holder.loadDataToView(locations.get(position));
        holder.actionView(locations.get(position));
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private View view;
        private TextView tvName, tvCode;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            this.init();
        }

        public void init(){
            this.tvName = this.view.findViewById(R.id.tv_name);
            this.tvCode = this.view.findViewById(R.id.tv_code);
        }

        public void actionView(Location location){
            this.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.setFragmentMainTravelCity(location);
                }
            });
        }

        public void loadDataToView(Location location){
            this.tvName.setText(location.getCity());
            this.tvCode.setText(String.format("(%s)", location.getCode()));
        }
    }
}
