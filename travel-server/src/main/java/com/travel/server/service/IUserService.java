package com.travel.server.service;

import com.travel.server.entity.User;

public interface IUserService {
    User getByUsername(String username);
}
