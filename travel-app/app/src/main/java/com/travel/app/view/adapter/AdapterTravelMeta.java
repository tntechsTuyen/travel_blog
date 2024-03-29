package com.travel.app.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.travel.app.MainActivity;
import com.travel.app.R;
import com.travel.app.common.view.icon.TextViewAwsSo;
import com.travel.app.data.model.Travel;
import com.travel.app.data.model.TravelMeta;

import java.util.List;

public class AdapterTravelMeta extends RecyclerView.Adapter<AdapterTravelMeta.ViewHolder> {

    private MainActivity context;
    private List<TravelMeta> travelMetas;
    private static final Integer RES_ID = R.layout.item_travel_meta;

    public AdapterTravelMeta(MainActivity context, List<TravelMeta> travelMetas) {
        this.context = context;
        this.travelMetas = travelMetas;
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
        holder.loadDataToView(travelMetas.get(position));
    }

    @Override
    public int getItemCount() {
        return travelMetas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private View view;
        private TextViewAwsSo twaBtnUp, twaBtnDown;
        private TextView tvMetaContent, tvMetaName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            this.init();
            this.actionView();
        }

        public void init(){
            this.twaBtnDown = this.view.findViewById(R.id.twas_btn_down);
            this.twaBtnUp = this.view.findViewById(R.id.twas_btn_up);
            this.tvMetaContent = this.view.findViewById(R.id.tv_travel_meta_content);
            this.tvMetaName = this.view.findViewById(R.id.tv_travel_meta_name);
        }

        public void actionView(){
            this.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (isShowContent()) {
                        hide();
                    } else {
                        show();
                    }
                }
            });
        }

        public void loadDataToView(TravelMeta travelMeta){
            this.tvMetaName.setText(travelMeta.getName());
            this.tvMetaContent.setText(travelMeta.getValue());
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
