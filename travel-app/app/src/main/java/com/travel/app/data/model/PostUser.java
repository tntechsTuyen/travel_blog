package com.travel.app.data.model;

public class PostUser {
    private Integer id;
    private Integer idPost;
    private Integer idUser;
    private Integer isRead;
    private Integer isLike;
    private Integer rate;

    public PostUser(){ }

    public PostUser(Integer idPost, Integer rate) {
        this.idPost = idPost;
        this.rate = rate;
    }
}
