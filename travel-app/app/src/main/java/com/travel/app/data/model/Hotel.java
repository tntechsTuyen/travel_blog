package com.travel.app.data.model;

import com.google.android.material.transition.Hold;

import lombok.Data;

@Data
public class Hotel extends Post{
    public Integer idHotel;
    public String phone;
    public String work;

    public Hotel(){
        super();
    }

    public Integer getIdHotel() {
        return idHotel;
    }

    public String getPhone() {
        return phone;
    }

    public String getWork() {
        return work;
    }
}
