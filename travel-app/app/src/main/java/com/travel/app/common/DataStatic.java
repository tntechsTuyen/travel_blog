package com.travel.app.common;

import lombok.Data;

@Data
public class DataStatic {

    public static final String BASE_URL = "http://192.168.1.163:1996/";
    public static final String STACK_APP = "TRAVEL_APP";

//    public static final String BASE_URL = "http://192.168.0.4:1996/";

    public static class HttpStatus{
        public static final int SUCCESS = 200;
        public static final int BAD_REQUEST = 400;
    }

    public static class SESSION {
        public static final String NAME = "SESSION_TRAVEL_APP";
        public static class KEY{
            public static final String AUTH = "AUTH";
        }
    }

    public static class CODE{
        public static final Integer CHOOSE_IMAGE = 102;
    }
}
