package com.travel.server.service;

import com.travel.server.entity.Media;
import org.springframework.web.multipart.MultipartFile;

public interface IMediaService {

    Media upload(MultipartFile file);
    Media save(String url);
}
