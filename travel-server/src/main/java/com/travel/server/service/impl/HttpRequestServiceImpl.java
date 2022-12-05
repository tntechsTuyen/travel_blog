package com.travel.server.service.impl;

import com.google.gson.Gson;
import com.travel.server.service.IHttpRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Service
public class HttpRequestServiceImpl implements IHttpRequestService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${firebase.key}")
    private String key;

    @Override
    public String post(String url, Object param) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(AUTHORIZATION, "key="+key);
        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        String body = "";
        if(param != null) {
            body = new Gson().toJson(param);
        }
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        return responseEntity.getBody();
    }
}
