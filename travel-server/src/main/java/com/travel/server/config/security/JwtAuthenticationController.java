package com.travel.server.config.security;

import com.travel.server.common.utils.CryptoUtils;
import com.travel.server.entity.User;
import com.travel.server.common.response.ApiResponse;
import com.travel.server.service.IFirebaseService;
import com.travel.server.service.IMailService;
import com.travel.server.service.IUserService;
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

	@Autowired
	private IFirebaseService firebaseService;

	@Autowired
	private IMailService mailService;

	@Autowired
	private IUserService userService;

	@PostMapping(value = "/login")
	public ApiResponse<Object> auth(@RequestBody User user) throws Exception {
		authenticate(user.getUsername(), user.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		User userInfo = userService.getByUsername(user.getUsername());
		userInfo.decryptData();
		String contentMail = String.format("Please click to: http://localhost:1996/token/generate?_p1=%s&_p2=%s&_p3=%s"
				, CryptoUtils.AES.encrypt(user.getUsername())
				, CryptoUtils.AES.encrypt(user.getPassword())
				, user.getDeviceId().replaceAll("\"", ""));
		mailService.sendMail(userInfo.getEmail(), contentMail);
		return ApiResponse.of(HttpStatus.OK, ApiResponse.Code.SUCCESS, "Checking mail", contentMail);
	}


	/**
	 * @param p1 : is username
	 * @param p2 : is password
	 * @param p3 : is device token
	 * */
	@GetMapping("/token/generate")
	public String tokenGeneral(@RequestParam("_p1") String p1, @RequestParam("_p2") String p2, @RequestParam("_p3") String p3) throws Exception {
		p1 = CryptoUtils.AES.decrypt(p1);
		p2 = CryptoUtils.AES.decrypt(p2);
		authenticate(p1, p2);
		final UserDetails userDetails = userDetailsService.loadUserByUsername(p1);
		final String token = jwtTokenUtil.generateToken(userDetails);
		firebaseService.sendAccessToken(p3, token);
		return "Login successful";
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
