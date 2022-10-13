package com.travel.app.data.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Date;

public class Location {
    private Integer id;
    private Double longitude;
    private Double latitude;
    private Integer code;
    private String address;
    private String city;
    private String country;
    private Date createdDate;

    public Integer getId() {
        return id;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Integer getCode() {
        return code;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public boolean equals(@NonNull Location location) {
        return location.getId().equals(this.getId());
    }
}
