package com.travel.server.controller;

import com.travel.server.common.response.ApiResponse;
import com.travel.server.common.utils.CryptoUtils;
import com.travel.server.config.security.JwtUserDetailsService;
import com.travel.server.service.IFirebaseService;
import com.travel.server.service.ILocationService;
import com.travel.server.service.ITravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

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
        deviceId = "d_3Fb8w7Gng:APA91bF8bAefdpcz41KfmPirzE1cuU_FnLflcBjP8327muPHaUB2MGm4FEm_MKO3JyPPeyvfyHfM7xmjCRJdz-3I81D55ahkbGlFwUPDZZeYckb6LDoumqKm-Ioo1oHKfHa6kyNjYzWZ";
        System.out.println("accessToken: "+accessToken);
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", firebaseService.sendAccessToken(deviceId, accessToken));
    }

    @PostMapping("/sha/test1")
    public ApiResponse<?> shaTest1(@RequestParam("s") String s) throws Exception {
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", CryptoUtils.AES.encrypt(s));
    }

    @PostMapping("/sha/test2")
    public ApiResponse<?> shaTest2(@RequestParam("s") String s) throws Exception {
        return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", CryptoUtils.AES.decrypt(s));
    }
}
