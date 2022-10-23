package com.travel.app.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.travel.app.MainActivity;
import com.travel.app.R;
import com.travel.app.common.utils.ImageUtils;
import com.travel.app.data.model.Travel;

import java.util.List;

public class AdapterTravelAds extends PagerAdapter {

    private MainActivity context;
    private List<Travel> travels;
    private static Integer RES_ID = R.layout.item_travel_ads;
    private LayoutInflater inflater;

    public AdapterTravelAds(MainActivity context, List<Travel> travels) {
        this.context = context;
        this.travels = travels;
    }

    @Override
    public int getCount() {
        return travels.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (ConstraintLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_travel_ads, container, false);
        ViewHolder viewHolder = new ViewHolder(v);
        viewHolder.loadDataToView(travels.get(position));
        viewHolder.actionView(travels.get(position));
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    public class ViewHolder{
        private View view;
        private ImageView ivThumb;
        private TextView tvAddress, tvTag, tvName, tvDescription, tvTotalView, tvTotalLike, tvTotalCmt, tvRatePoint;

        public ViewHolder(View itemView) {
            this.view = itemView;
            this.init();
        }

        public void init(){
            this.ivThumb = this.view.findViewById(R.id.iv_thumb);
            this.tvAddress = this.view.findViewById(R.id.tv_travel_city);
            this.tvTag = this.view.findViewById(R.id.tv_travel_tag);
            this.tvName = this.view.findViewById(R.id.tv_travel_name);
            this.tvDescription = this.view.findViewById(R.id.tv_description);
            this.tvTotalView = this.view.findViewById(R.id.tv_total_view);
            this.tvTotalLike = this.view.findViewById(R.id.tv_total_like);
            this.tvTotalCmt = this.view.findViewById(R.id.tv_travel_total_cmt);
            this.tvRatePoint = this.view.findViewById(R.id.tv_travel_rate_point);
        }

        public void loadDataToView(Travel travel){
            this.tvAddress.setText(travel.getCity());
            this.tvTag.setText(travel.getTagName());
            this.tvName.setText(travel.getName());
            this.tvDescription.setText(travel.getDescription());
            this.tvTotalView.setText(String.valueOf(travel.getTotalView()));
            this.tvTotalLike.setText(String.valueOf(travel.getTotalLike()));
            this.tvTotalCmt.setText(String.valueOf(travel.getTotalComment()));
            this.tvRatePoint.setText(String.valueOf(travel.getRatePoint()));
            ImageUtils.loadUrl(context, this.ivThumb, travel.getMediaUrl());
        }

        public void actionView(Travel travel){
            this.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.setFragmentMainTravelDetail(travel);
                }
            });
        }
    }
}
