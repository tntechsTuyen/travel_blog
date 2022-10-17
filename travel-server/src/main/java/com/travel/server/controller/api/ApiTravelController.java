package com.travel.server.controller.api;

import com.travel.server.common.response.ApiResponse;
import com.travel.server.service.IHotelService;
import com.travel.server.service.ITravelMetaService;
import com.travel.server.service.ITravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/travel")
public class ApiTravelController {

    @Autowired
    private ITravelService travelService;

    @Autowired
    private ITravelMetaService travelMetaService;

    @Autowired
    private IHotelService hotelService;

    @GetMapping("/list")
    public ApiResponse<?> travelList(){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", travelService.getTravelList());
    }

    @GetMapping("/ads")
    public ApiResponse<?> travelAds(){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", travelService.getTravelAds());
    }

    @GetMapping("/top")
    public ApiResponse<?> travelTop(){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", travelService.getTravelTop());
    }

    @GetMapping("/{id}")
    public ApiResponse<?> travelDetail(@PathVariable("id") Integer id, @RequestParam(value = "type", required = false, defaultValue = "POST") String type){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", travelService.getTravelDetail(id, type));
    }

    @GetMapping("/city/{code}")
    public ApiResponse<?> travelCity(@PathVariable("code") Integer code){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", travelService.getTravelLocationCode(code));
    }

    @GetMapping("/{id}/metas")
    public ApiResponse<?> metas(@PathVariable("id") Integer id){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", travelMetaService.getByIdTravel(id));
    }

    @GetMapping("/{id}/hotel")
    public ApiResponse<?> travelHotel(@PathVariable("id") Integer id, @RequestParam(value = "distance", required = false, defaultValue = "10") Double distance){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", hotelService.getHotelByTravel(id, distance));
    }

    @GetMapping("/hotel/{id}")
    public ApiResponse<?> hotelDetail(@PathVariable("id") Integer id, @RequestParam(value = "type", required = false, defaultValue = "POST") String type){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", travelService.getTravelDetail(id, type));
    }

}
