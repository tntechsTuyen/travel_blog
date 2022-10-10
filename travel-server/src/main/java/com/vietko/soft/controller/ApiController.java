package com.vietko.soft.controller;

import com.vietko.soft.common.response.ApiResponse;
import com.vietko.soft.config.security.JwtUserDetailsService;
import com.vietko.soft.entity.User;
import com.vietko.soft.service.IUserService;
import com.vietko.soft.service.impl.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * @description: Api for app
 * @list:
 * Method   Url
 * [GET]   /user/info
 * */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @GetMapping("/travel/ads")
    public ApiResponse<?> travelAds(){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", null);
    }

    @GetMapping("/travel/top")
    public ApiResponse<?> travelTop(){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", null);
    }

    @GetMapping("/travel/detail/{id}")
    public ApiResponse<?> travelDetail(@PathVariable("id") Integer id){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", null);
    }

    @GetMapping("/user/travel/hobbies")
    public ApiResponse<?> travelHobbies(){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", null);
    }

    @GetMapping("/location/travel")
    public ApiResponse<?> locationTravel(){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", null);
    }

    @GetMapping("/travel/hotel")
    public ApiResponse<?> travelHotel(){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", null);
    }

    @GetMapping("/hotel/detail/{id}")
    public ApiResponse<?> hotelDetail(@PathVariable("id") Integer id){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", null);
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
