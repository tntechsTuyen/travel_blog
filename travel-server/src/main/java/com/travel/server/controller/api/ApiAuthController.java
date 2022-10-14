package com.travel.server.controller.api;

import com.travel.server.common.response.ApiResponse;
import com.travel.server.config.security.JwtUserDetailsService;
import com.travel.server.service.ILocationService;
import com.travel.server.service.ITravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class ApiAuthController {

    @Autowired
    private ITravelService travelService;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @GetMapping("/travel/hobbies")
    public ApiResponse<?> travelHobbies(){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", travelService.getTravelHobbies());
    }

    @GetMapping("/info")
    public ApiResponse<?> info(){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", userDetailsService.getUserLogin());
    }
}
