package com.travel.app.common;

import lombok.Data;

@Data
public class DataStatic {

//    public static final String BASE_URL = "http://192.168.1.163:1996/";
    public static final String BASE_URL = "http://192.168.0.4:1996/";

    public static class HttpStatus{
        public static final Integer SUCCESS = 200;
    }
}
