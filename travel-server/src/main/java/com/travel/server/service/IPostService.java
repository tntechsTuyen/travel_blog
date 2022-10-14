package com.travel.server.service;

import com.travel.server.entity.PostUser;

public interface IPostService {

    PostUser read(Integer idPost, Integer idUser);
    PostUser like(Integer idPost, Integer idUser);
    PostUser rate(PostUser postUser);
    void comment(Integer idPost);
}
