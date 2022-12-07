package com.travel.server.controller.api;

import com.travel.server.common.response.ApiResponse;
import com.travel.server.config.security.JwtUserDetailsService;
import com.travel.server.entity.User;
import com.travel.server.service.ILocationService;
import com.travel.server.service.ITravelService;
import com.travel.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/update")
    public ApiResponse<?> updateProfile(@RequestBody User user){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", userDetailsService.updateUser(user));
    }
}
