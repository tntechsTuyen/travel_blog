package com.travel.server.service;

import com.travel.server.entity.Comment;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

public interface ICommentService {

    List<Map<String, Object>> findByIdPost(Integer idPost);
    Object commentPost(Integer idPost, Integer idParent, String content, MultipartFile file);
    Map<String, Object> save(Comment comment);
}
