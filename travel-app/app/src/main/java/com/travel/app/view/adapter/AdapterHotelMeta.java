package com.travel.app.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.travel.app.MainActivity;
import com.travel.app.R;
import com.travel.app.common.view.TextViewAws.TextViewAwsSo;
import com.travel.app.data.model.HotelMeta;
import com.travel.app.data.model.TravelMeta;

import java.util.List;

public class AdapterHotelMeta extends RecyclerView.Adapter<AdapterHotelMeta.ViewHolder> {

    private MainActivity context;
    private List<HotelMeta> hotelMetas;
    private static final Integer RES_ID = R.layout.item_hotel_meta;

    public AdapterHotelMeta(MainActivity context, List<HotelMeta> hotelMetas) {
        this.context = context;
        this.hotelMetas = hotelMetas;
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
                if (viewHolder.isShowContent()) {
                    viewHolder.hide();
                } else {
                    viewHolder.show();
                }
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return hotelMetas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private View view;
        private TextViewAwsSo twaBtnUp, twaBtnDown;
        private TextView tvMetaContent, tvMetaName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            this.init();
        }

        public void init(){
            this.twaBtnDown = this.view.findViewById(R.id.twas_btn_down);
            this.twaBtnUp = this.view.findViewById(R.id.twas_btn_up);
            this.tvMetaContent = this.view.findViewById(R.id.tv_hotel_meta_content);
            this.tvMetaName = this.view.findViewById(R.id.tv_hotel_meta_name);
        }

        public void loadDataToView(){

        }

        public void hide(){
            this.twaBtnUp.setVisibility(View.GONE);
            this.twaBtnDown.setVisibility(View.VISIBLE);
            this.tvMetaContent.setVisibility(View.GONE);
        }

        public void show(){
            this.twaBtnUp.setVisibility(View.VISIBLE);
            this.twaBtnDown.setVisibility(View.GONE);
            this.tvMetaContent.setVisibility(View.VISIBLE);
        }

        public boolean isShowContent(){
            return (this.tvMetaContent.getVisibility() == View.VISIBLE);
        }
    }
}
