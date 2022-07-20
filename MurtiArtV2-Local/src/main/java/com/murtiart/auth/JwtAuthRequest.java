package com.murtiart.auth;

import com.murtiart.user.UserDto;

import lombok.Data;

@Data
public class JwtAuthRequest {
	
	private String username; // This is email
	
	private Integer roleId;
	
    private UserDto user;
}
