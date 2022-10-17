package com.travel.app.view.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.travel.app.MainActivity;
import com.travel.app.R;
import com.travel.app.common.utils.LocationUtils;
import com.travel.app.data.model.Hotel;
import com.travel.app.data.model.Travel;

import java.util.List;

@SuppressLint({"SetTextI18n","DefaultLocale"})
public class AdapterTravelHotel extends RecyclerView.Adapter<AdapterTravelHotel.ViewHolder> {

    private MainActivity context;
    private List<Hotel> hotels;
    private static final Integer RES_ID = R.layout.item_travel_hotel;
    private Travel travel;

    public AdapterTravelHotel(MainActivity context, List<Hotel> hotels) {
        this.context = context;
        this.hotels = hotels;
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
        holder.loadDataToView(hotels.get(position));
        holder.actionView(hotels.get(position));
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private View view;
        private ImageView ivThumb;
        private TextView tvName, tvAddress, tvPhone, tvWork, tvDistance;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            this.init();
        }

        public void init(){
            this.ivThumb = this.view.findViewById(R.id.iv_thumb);
            this.tvName = this.view.findViewById(R.id.tv_name);
            this.tvAddress = this.view.findViewById(R.id.tv_address);
            this.tvPhone = this.view.findViewById(R.id.tv_phone);
            this.tvWork = this.view.findViewById(R.id.tv_work);
            this.tvDistance = this.view.findViewById(R.id.tv_distance);
        }

        public void loadDataToView(Hotel hotel){
            this.tvName.setText(hotel.getName());
            this.tvAddress.setText(hotel.getAddress());
            this.tvPhone.setText(hotel.getPhone());
            this.tvWork.setText(hotel.getWork());
            if(travel != null){
                String strDistance = String.format("%.1f", LocationUtils.distance(travel.getLat(), travel.getLon(), hotel.getLat(), hotel.getLon())).concat("km");
                this.tvDistance.setText(strDistance);
            }
        }

        public void actionView(Hotel hotel){
            this.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.setFragmentMainHotelDetail(hotel);
                }
            });
        }
    }
}
