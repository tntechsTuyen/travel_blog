package com.vietko.soft.common.response;

import lombok.Value;
import org.springframework.http.HttpStatus;

@Value(staticConstructor = "of")
public class CommonResponse<T> {

    private Integer status;

    private ResponseCode code;

    private String message;

    private T result;

}
