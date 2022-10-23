package com.travel.app.data.model;

import com.google.android.material.transition.Hold;

import lombok.Data;

@Data
public class Hotel {

    public Integer id;
    public String phone;
    public String work;
    private Integer idPost;
    private String name;
    private String description;
    private Double lon;
    private Double lat;
    private String address;
    private String country;
    private String city;
    private Integer totalView;
    private Integer totalLike;
    private Integer totalComment;
    private Double ratePoint;
    private Integer rateCount;
    private String mediaType;
    private String mediaUrl;
    private String tagName;
    private Integer isLike;
    private Integer rate;

    public Hotel(){

    }

    public Integer getRateCount() {
        return rateCount;
    }

    public Integer getIsLike() {
        return isLike;
    }

    public Integer getRate() {
        return rate;
    }

    public Integer getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getWork() {
        return work;
    }


    public Integer getTotalComment() {
        return totalComment;
    }

    public Integer getIdPost() {
        return idPost;
    }

    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
    }

    public void setTotalComment(Integer totalComment) {
        this.totalComment = totalComment;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getTotalView() {
        return totalView;
    }

    public void setTotalView(Integer totalView) {
        this.totalView = totalView;
    }

    public Double getRatePoint() {
        return ratePoint;
    }

    public void setRatePoint(Double ratePoint) {
        this.ratePoint = ratePoint;
    }

    public Integer getTotalLike() {
        return totalLike;
    }

    public void setTotalLike(Integer totalLike) {
        this.totalLike = totalLike;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public Double getLon() {
        return lon;
    }

    public Double getLat() {
        return lat;
    }
}
