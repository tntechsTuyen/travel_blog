package com.travel.app.common.reponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
public class ApiResponse<T> {

    @SerializedName("status")
    @Expose
    private Integer status;

    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("result")
    @Expose
    private T result;

    public Integer getStatus() {
        return status;
    }

    public T getResult() {
        return result;
    }
}
