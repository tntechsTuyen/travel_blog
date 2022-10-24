package com.travel.app.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import android.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.travel.app.MainActivity;
import com.travel.app.R;
import com.travel.app.common.utils.ImageUtils;
import com.travel.app.data.model.Comment;
import com.travel.app.data.model.Hotel;
import com.travel.app.data.model.Travel;
import com.travel.app.view.fragment.FragmentMainHotelDetail;
import com.travel.app.view.fragment.FragmentMainTravelDetail;

import java.util.List;

public class AdapterComment extends RecyclerView.Adapter<AdapterComment.ViewHolder> {

    private MainActivity context;
    private List<Comment> comments;
    private static final Integer RES_ID = R.layout.item_comment;
    private Fragment fragment;

    public AdapterComment(MainActivity context, List<Comment> comments, Fragment fragment) {
        this.context = context;
        this.comments = comments;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(RES_ID, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.loadDataToView(comments.get(position));
        holder.actionView(comments.get(position));
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private View view;
        private TextView tvUser, tvContent, tvTime, tvReply;
        private ImageView ivMedia;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            this.init();
        }

        private void init(){
            this.tvUser = this.view.findViewById(R.id.tv_user);
            this.tvContent = this.view.findViewById(R.id.tv_content);
            this.tvTime = this.view.findViewById(R.id.tv_time);
            this.tvReply = this.view.findViewById(R.id.tv_reply);
            this.ivMedia = this.view.findViewById(R.id.iv_media);
        }

        public void actionView(Comment comment){
            this.tvReply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(fragment == null) return;
                    if (fragment instanceof FragmentMainTravelDetail){
                        ((FragmentMainTravelDetail) fragment).setCommentReply(comment);
                    }else if(fragment instanceof FragmentMainHotelDetail){
                        ((FragmentMainHotelDetail) fragment).setCommentReply(comment);
                    }
                }
            });
        }

        public void loadDataToView(Comment comment){
            this.tvUser.setText(comment.getUsername());
            this.tvContent.setText(comment.getContent());
            this.tvTime.setText(comment.getTime());
            if(comment.getMediaUrl() != null && comment.getMediaUrl().length() > 0){
                this.ivMedia.setVisibility(View.VISIBLE);
                ImageUtils.loadUrl(context, this.ivMedia, comment.getMediaUrl());
            }else{
                this.ivMedia.setVisibility(View.GONE);
            }
        }
    }
}
