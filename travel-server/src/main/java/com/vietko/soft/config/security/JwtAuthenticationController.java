package com.vietko.soft.config.security;

import com.vietko.soft.common.response.ApiResponse;
import com.vietko.soft.entity.User;
import com.vietko.soft.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * @description: Api auth in system
 * @list:
 * Method	Url
 * [POST]	/auth
 * */
@RestController
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@PostMapping(value = "/auth")
	public ApiResponse<Object> auth(@RequestBody User user) throws Exception {
		authenticate(user.getUsername(), user.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Login successful", token);
	}

	@PostMapping(value = "/register")
	public ApiResponse<Object> register(@RequestBody User user) throws Exception {
		return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Load data successful", userDetailsService.register(user));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
