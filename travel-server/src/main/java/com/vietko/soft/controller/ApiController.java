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
 * [POST]   /register
 * */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private JwtUserDetailsService userDetailsService;

    /**
     * Header:
     * Authorization: Bearer {token}
     * */
    @GetMapping("/info")
    public ApiResponse<?> info(Principal principal){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", principal.getName());
    }
}
