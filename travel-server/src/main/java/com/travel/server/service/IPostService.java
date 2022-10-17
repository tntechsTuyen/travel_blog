package com.travel.server.service;

import com.travel.server.entity.PostUser;

public interface IPostService {

    PostUser read(Integer idPost, Integer idUser);
    PostUser like(PostUser mPostUser);
    PostUser rate(PostUser mPostUser);
    void comment(Integer idPost);
}
