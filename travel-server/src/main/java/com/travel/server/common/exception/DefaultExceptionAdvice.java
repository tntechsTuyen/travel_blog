package com.travel.server.common.exception;

import com.travel.server.common.response.ApiResponse;
import com.travel.server.common.response.CommonResponse;
import com.travel.server.common.response.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class DefaultExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CommonException.class)
    public ApiResponse<Object> handleException(CommonException ce) {
        ApiResponse<Object> response = ApiResponse.of(HttpStatus.BAD_REQUEST, ApiResponse.Code.FAILED, ce.getMessage(), null);
        log.error("Exception###: ",ce);
        return response;
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<Object> handleException(Exception e) {
        ApiResponse<Object> response = ApiResponse.of(HttpStatus.BAD_REQUEST, ApiResponse.Code.FAILED, e.getMessage(), null);
        log.error("Exception###: ",e);
        return response;
    }
}