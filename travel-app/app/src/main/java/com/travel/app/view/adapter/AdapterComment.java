package com.travel.app.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.travel.app.MainActivity;
import com.travel.app.R;
import com.travel.app.data.model.Comment;
import com.travel.app.data.model.Hotel;
import com.travel.app.data.model.Travel;

import java.util.List;

public class AdapterComment extends RecyclerView.Adapter<AdapterComment.ViewHolder> {

    private MainActivity context;
    private List<Comment> comments;
    private static final Integer RES_ID = R.layout.item_comment;

    public AdapterComment(MainActivity context, List<Comment> comments) {
        this.context = context;
        this.comments = comments;
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
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.loadDataToView(comments.get(position));
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private View view;
        private TextView tvUser, tvContent, tvTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            this.init();
        }

        public void init(){
            this.tvUser = this.view.findViewById(R.id.tv_user);
            this.tvContent = this.view.findViewById(R.id.tv_content);
            this.tvTime = this.view.findViewById(R.id.tv_time);
        }

        public void loadDataToView(Comment comment){
            this.tvUser.setText(comment.getFullName());
            this.tvContent.setText(comment.getContent());
            this.tvTime.setText(comment.getTime());
        }
    }
}
