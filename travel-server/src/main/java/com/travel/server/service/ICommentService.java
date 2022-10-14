package com.travel.server.service;

import com.travel.server.entity.Comment;

import java.util.*;

public interface ICommentService {

    List<Map<String, Object>> findByIdPost(Integer idPost);
    Map<String, Object> save(Comment comment);
}
