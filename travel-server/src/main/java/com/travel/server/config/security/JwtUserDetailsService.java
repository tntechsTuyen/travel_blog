package com.travel.server.config.security;

import com.travel.server.entity.User;
import com.travel.server.repository.UserRepository;
import com.travel.server.common.utils.CryptoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public User register(User mUser) throws Exception {
		//Check username is exists
		User userCheckExists = userRepository.findByUsername(mUser.getUsername());
		if(userCheckExists != null) throw new Exception("The accounts already exists");

		//Encode password
		mUser.setPassword(CryptoUtils.BCrypt(mUser.getPassword()));

		//Save data
		userRepository.save(mUser);
		return mUser;
	}

	public User getUserLogin(){
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		String username = userDetails.getUsername();
		User userLogin = userRepository.findByUsername(username);
		userLogin.decryptData();
		userLogin.setPassword("");
		return userLogin;
	}

	public User updateUser(User user){
		User userLogin = getUserLogin();
		if(user.getPassword() != null && user.getPassword().trim().length() > 0){
			userLogin.setPassword(CryptoUtils.BCrypt(user.getPassword()));
		}
		userLogin.encryptData(user);
		userRepository.save(userLogin);
		return userLogin;
	}
}