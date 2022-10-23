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

    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
    }

    public void setIsLike(Integer isLike) {
        this.isLike = isLike;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdPost() {
        return idPost;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public Integer getIsLike() {
        return isLike;
    }

    public Integer getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "PostUser{" +
                "id=" + id +
                ", idPost=" + idPost +
                ", idUser=" + idUser +
                ", isRead=" + isRead +
                ", isLike=" + isLike +
                ", rate=" + rate +
                '}';
    }
}
