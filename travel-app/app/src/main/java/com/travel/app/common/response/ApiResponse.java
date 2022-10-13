package com.travel.app.common.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class ApiResponse<T> {

    private Integer status;
    private String code;
    private String message;
    private T result;

    public Integer getStatus() {
        return status;
    }

    public T getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }
}
