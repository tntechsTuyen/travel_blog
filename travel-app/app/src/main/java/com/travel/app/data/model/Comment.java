package com.travel.app.data.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Comment {
    public int id;
    public int idPost;
    public int idUser;
    public int idParent;
    public String fullName;
    public String content;
    public Long createdDate;

    public Comment(){}

    public Comment(Integer idPost, String content) {
        this.idPost = idPost;
        this.content = content;
        this.idParent = 0;
    }

    public int getId() {
        return id;
    }

    public int getIdPost() {
        return idPost;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdParent() {
        return idParent;
    }

    public String getFullName() {
        return fullName;
    }

    public String getContent() {
        return content;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public String getTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        return formatter.format(new Date(this.createdDate));
    }
}
