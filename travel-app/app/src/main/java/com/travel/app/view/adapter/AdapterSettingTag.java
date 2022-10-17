package com.travel.app.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.travel.app.MainActivity;
import com.travel.app.R;
import com.travel.app.common.view.icon.TextViewAwsSo;
import com.travel.app.data.model.HotelMeta;
import com.travel.app.data.model.Tag;

import java.util.ArrayList;
import java.util.List;

public class AdapterSettingTag extends RecyclerView.Adapter<AdapterSettingTag.ViewHolder> {

    private MainActivity context;
    private List<Tag> tags;
    private List<Integer> lstIdChecked = new ArrayList<>();
    private static final Integer RES_ID = R.layout.item_setting_tag;

    public AdapterSettingTag(MainActivity context, List<Tag> tags) {
        this.context = context;
        this.tags = tags;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(RES_ID, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public List<Integer> getLstIdChecked() {
        return lstIdChecked;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.loadDataToView(tags.get(position));
        holder.actionView(tags.get(position));
    }

    @Override
    public int getItemCount() {
        return tags.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private View view;
        private TextView tvName;
        private CheckBox cbTag;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            this.init();
        }

        public void init(){
            this.tvName = this.view.findViewById(R.id.tv_tag_name);
            this.cbTag = this.view.findViewById(R.id.cb_tag);
        }

        public void actionView(Tag tag){
            this.cbTag.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b){
                        lstIdChecked.add(tag.getId());
                    }else{
                        lstIdChecked.remove(tag.getId());
                    }
                }
            });
        }

        public void loadDataToView(Tag tag){
            this.tvName.setText(tag.getName());
            if(tag.getIdUser() != null){
                this.cbTag.setChecked(true);
                lstIdChecked.add(tag.getId());
            }
        }

    }
}
