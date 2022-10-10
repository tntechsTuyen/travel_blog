package com.vietko.soft.service.impl;

import com.vietko.soft.common.utils.CryptoUtils;
import com.vietko.soft.config.security.JwtUserDetailsService;
import com.vietko.soft.entity.User;
import com.vietko.soft.repository.UserRepository;
import com.vietko.soft.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;


}
