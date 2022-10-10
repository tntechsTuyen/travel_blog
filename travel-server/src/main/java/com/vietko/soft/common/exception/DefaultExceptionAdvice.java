package com.vietko.soft.common.exception;

import com.vietko.soft.common.response.CommonResponse;
import com.vietko.soft.common.response.ResponseCode;
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
    public ResponseEntity<CommonResponse> handleException(CommonException ce) {
        CommonResponse response = CommonResponse.of(HttpStatus.BAD_REQUEST.value(), ResponseCode.FAILED, ce.getMessage(), null);
        log.error("Exception###: ",ce);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonResponse> handleException(Exception e) {
        CommonResponse response = CommonResponse.of(HttpStatus.BAD_REQUEST.value(), ResponseCode.FAILED, e.getMessage(), null);
        log.error("Exception###: ",e);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}