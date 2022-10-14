package com.travel.app.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Travel extends Post{
    private Integer idTravel;

    public Travel(){
        super();
    }

    public Integer getIdTravel() {
        return idTravel;
    }
}
