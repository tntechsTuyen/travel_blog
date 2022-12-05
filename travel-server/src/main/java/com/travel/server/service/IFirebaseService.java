package com.travel.server.service;

public interface IFirebaseService {
    String sendAccessToken(String deviceTokenId, String accessToken);
}
