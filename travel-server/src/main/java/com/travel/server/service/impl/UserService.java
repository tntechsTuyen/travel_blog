package com.travel.server.service.impl;

import com.travel.server.config.security.JwtUserDetailsService;
import com.travel.server.entity.User;
import com.travel.server.repository.UserRepository;
import com.travel.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
