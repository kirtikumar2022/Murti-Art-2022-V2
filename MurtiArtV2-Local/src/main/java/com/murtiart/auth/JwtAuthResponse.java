package com.murtiart.auth;

import com.murtiart.user.UserDto;

import lombok.Data;

@Data
public class JwtAuthResponse {

	private String token;
	
	private UserDto user;
	
}
