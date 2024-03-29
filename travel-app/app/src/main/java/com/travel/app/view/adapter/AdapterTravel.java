package com.travel.app.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.travel.app.MainActivity;
import com.travel.app.R;
import com.travel.app.common.utils.ImageUtils;
import com.travel.app.data.model.Travel;

import java.util.List;

public class AdapterTravel extends RecyclerView.Adapter<AdapterTravel.ViewHolder> {

    private MainActivity context;
    private List<Travel> travels;
    private static final Integer RES_ID = R.layout.item_travel;

    public AdapterTravel(MainActivity context, List<Travel> travels) {
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
        holder.actionView(travel);
    }

    @Override
    public int getItemCount() {
        return travels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private View view;
        private ImageView ivThumb;
        private TextView tvAddress, tvTag, tvName, tvDescription, tvTotalView, tvTotalLike, tvTotalCmt, tvRatePoint;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            this.init();
        }

        public void init(){
            this.ivThumb = this.view.findViewById(R.id.iv_thumb);
            this.tvAddress = this.view.findViewById(R.id.tv_travel_city);
            this.tvName = this.view.findViewById(R.id.tv_travel_name);
            this.tvDescription = this.view.findViewById(R.id.tv_description);
            this.tvTotalView = this.view.findViewById(R.id.tv_total_view);
            this.tvTotalLike = this.view.findViewById(R.id.tv_total_like);
            this.tvTotalCmt = this.view.findViewById(R.id.tv_travel_total_cmt);
            this.tvRatePoint = this.view.findViewById(R.id.tv_travel_rate_point);
        }

        public void actionView(Travel travel){
            this.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.setFragmentMainTravelDetail(travel);
                }
            });
        }

        public void loadDataToView(Travel travel){
            this.tvAddress.setText(travel.getCity());
            this.tvName.setText(travel.getName());
            this.tvDescription.setText(travel.getDescription());
            this.tvTotalView.setText(String.valueOf(travel.getTotalView()));
            this.tvTotalLike.setText(String.valueOf(travel.getTotalLike()));
            this.tvTotalCmt.setText(String.valueOf(travel.getTotalComment()));
            this.tvRatePoint.setText(String.valueOf(travel.getRatePoint()));
            ImageUtils.loadUrl(context, this.ivThumb, travel.getMediaUrl());
        }
    }
}
