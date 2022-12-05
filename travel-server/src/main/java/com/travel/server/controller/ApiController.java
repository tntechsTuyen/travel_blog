package com.travel.server.controller;

import com.travel.server.common.response.ApiResponse;
import com.travel.server.config.security.JwtUserDetailsService;
import com.travel.server.service.IFirebaseService;
import com.travel.server.service.ILocationService;
import com.travel.server.service.ITravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @description: Api for app
 * @list:
 * Method   Url
 * [GET]
 * */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private ITravelService travelService;

    @Autowired
    private ILocationService locationService;

    @Autowired
    private IFirebaseService firebaseService;

    @GetMapping("/user/travel/hobbies")
    public ApiResponse<?> travelHobbies(){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", travelService.getTravelHobbies());
    }

    @GetMapping("/location")
    public ApiResponse<?> location(){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", locationService.getDistinct());
    }

    @PostMapping("/mess/test")
    public ApiResponse<?> messTest(@RequestParam("access_token") String accessToken){
        String deviceId = "eKDlkgrJUT0:APA91bF4sBOuH1WOzNwUcLNrrT2OUMSuHlt7oiLQw25-QdfCa6hfGkCNYTKqLo4sUGC_RC1VCsB543uYAdH9zmMcZiJidKVXzEmUs120CdGNZvNqyqjWSRgzl2CboUCp8DI5BZmqs6jP";
        System.out.println("accessToken: "+accessToken);
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", firebaseService.sendAccessToken(deviceId, accessToken));
    }

    /**
     * Header:
     * Authorization: Bearer {token}
     * */
    @GetMapping("/user/info")
    public ApiResponse<?> userInfo(){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", userDetailsService.getUserLogin());
    }
}
