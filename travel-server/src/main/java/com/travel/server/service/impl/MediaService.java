package com.travel.server.service.impl;

import com.travel.server.config.security.JwtUserDetailsService;
import com.travel.server.entity.Media;
import com.travel.server.entity.User;
import com.travel.server.repository.MediaRepository;
import com.travel.server.service.IFileService;
import com.travel.server.service.IMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MediaService implements IMediaService {

    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private IFileService fileService;

    @Override
    public Media upload(MultipartFile file) {
        String url = fileService.updloadFile(file);
//        String url = "";
        return save(url);
    }

    @Override
    public Media save(String url) {
        User user = userDetailsService.getUserLogin();
        Media media = new Media();
        media.setType("image");
        media.setIdUser(user.getId());
        media.setUrl(url);
        mediaRepository.save(media);
        return media;
    }
}
