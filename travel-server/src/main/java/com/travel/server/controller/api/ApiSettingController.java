package com.travel.server.controller.api;


import com.travel.server.common.response.ApiResponse;
import com.travel.server.service.ITagService;
import com.travel.server.service.impl.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/setting")
public class ApiSettingController {

    @Autowired
    private ITagService tagService;

    @GetMapping("/tag/list")
    public ApiResponse<?> tagList(){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", tagService.getList());
    }

    @PostMapping("/tag/update")
    public ApiResponse<?> tagUpdate(@RequestBody List<Integer> idTags){
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", tagService.update(idTags));
    }
}
