package com.travel.server.controller.api;

import com.travel.server.common.response.ApiResponse;
import com.travel.server.service.ITravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/travel")
public class ApiTravelController {

    @Autowired
    private ITravelService travelService;

    @GetMapping("/ads")
    public ApiResponse<?> travelAds(){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", travelService.getTravelAds());
    }

    @GetMapping("/top")
    public ApiResponse<?> travelTop(){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", travelService.getTravelTop());
    }

    @GetMapping("/{id}")
    public ApiResponse<?> travelDetail(@PathVariable("id") Integer id){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", travelService.getTravelDetail(id));
    }

    @GetMapping("/travel/city/{code}")
    public ApiResponse<?> travelCity(@PathVariable("code") Integer code){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", travelService.getTravelLocationCode(code));
    }

    @GetMapping("/travel/{id}/hotel")
    public ApiResponse<?> travelHotel(@PathVariable("id") Integer id){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", null);
    }

    @GetMapping("/hotel/{id}")
    public ApiResponse<?> hotelDetail(@PathVariable("id") Integer id){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", travelService.getTravelDetail(id));
    }

}
