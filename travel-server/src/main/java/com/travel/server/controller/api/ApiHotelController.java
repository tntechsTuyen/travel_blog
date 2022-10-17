package com.travel.server.controller.api;

import com.travel.server.common.response.ApiResponse;
import com.travel.server.service.IHotelMetaService;
import com.travel.server.service.IHotelService;
import com.travel.server.service.ITravelMetaService;
import com.travel.server.service.ITravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hotel")
public class ApiHotelController {

    @Autowired
    private IHotelService hotelService;

    @Autowired
    private IHotelMetaService hotelMetaService;

    @GetMapping("/{id}")
    public ApiResponse<?> travelDetail(@PathVariable("id") Integer id){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", hotelService.getHotelDetail(id));
    }

    @GetMapping("/{id}/metas")
    public ApiResponse<?> metas(@PathVariable("id") Integer id){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", hotelMetaService.getByIdHotel(id));
    }

}
