package com.travel.server.controller;

import com.travel.server.common.response.ApiResponse;
import com.travel.server.config.security.JwtUserDetailsService;
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

    @GetMapping("/user/travel/hobbies")
    public ApiResponse<?> travelHobbies(){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", travelService.getTravelHobbies());
    }

    @GetMapping("/location")
    public ApiResponse<?> location(){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", locationService.getDistinct());
    }

    @GetMapping("/post/{id_post}/commend")
    public ApiResponse<?> goPostCommend(@PathVariable("id_post") Integer idPost){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", null);
    }

    @PostMapping("/post/{id_post}/commend")
    public ApiResponse<?> doPostCommend(@PathVariable("id_post") Integer idPost){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", null);
    }

    @GetMapping("/post/{id_post}/rate")
    public ApiResponse<?> goPostRate(@PathVariable("id_post") Integer idPost){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", null);
    }

    @PostMapping("/post/{id_post}/rate")
    public ApiResponse<?> doPostRate(@PathVariable("id_post") Integer idPost){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", null);
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
