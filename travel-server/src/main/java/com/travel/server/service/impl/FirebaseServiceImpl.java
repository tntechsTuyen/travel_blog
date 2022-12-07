package com.travel.server.service.impl;

import com.travel.server.dto.FirebaseMessageDTO;
import com.travel.server.service.IFirebaseService;
import com.travel.server.service.IHttpRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FirebaseServiceImpl implements IFirebaseService {

    @Value("${firebase.api}")
    private String api;

    @Autowired
    private IHttpRequestService httpRequestService;

    @Override
    public String sendAccessToken(String deviceTokenId, String accessToken) {
        FirebaseMessageDTO firebaseMessageDTO = new FirebaseMessageDTO();
        firebaseMessageDTO.setTo(deviceTokenId);
        firebaseMessageDTO.getData().setAccessToken(accessToken);
        String result = httpRequestService.post(api, firebaseMessageDTO);
        return result;
    }
}
