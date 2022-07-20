package com.murtiart.auth;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.murtiart.roles.RoleDto;
import com.murtiart.secuirty.JwtTokenHelper;
import com.murtiart.user.UserDto;
import com.murtiart.user.UserService;
import com.murtiart.utils.GenericApiRespons;
import com.murtiart.utils.JsonKeysManageGlobally;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper; 
	
	@Autowired
	private UserDetailsService detailsService;
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/login")
	public GenericApiRespons<JwtAuthResponse> loginUser(@RequestBody JwtAuthRequest requst) {
		
		// Check user is already present in DB or not
		Boolean isUserExist = this.userService.isUserExist(requst.getUsername());
		
		// LOGIN CHECK
	    if(isUserExist) {
			
				UserDetails userDetail = this.detailsService.loadUserByUsername(requst.getUsername());
				UserDto user = this.userService.getUserByEmail(requst.getUsername());
				return response(true,"Fetch successfully", user,userDetail,0);
						
				}
	    
	    // REGISTER 
	    else {
	    	
	    	UserDto dto =  requst.getUser();
	    	
	    	  // REGISTER USER DATA NOT NULL
	    	if (dto!=null) {
	    		
	    		if(requst.getRoleId()!=null) {
		    		
		    		  // REGISTER USER EMAIL AND USERNAME NEED TO SAME
		    		if (dto.getEmail().equals(requst.getUsername())) {
		    			
		    			
		    			// ADMIN
						if (requst.getRoleId() == 1) {
							
							// 1. Create user
							dto.setRequest(0);
							dto.setIsActive(true);
							dto.setRating(5);
							dto.setSubscription(new Date().getTime());
							
							UserDto registerNewUser = registerUserDto(dto, requst.getRoleId());
							UserDetails userDetail = this.detailsService.loadUserByUsername(registerNewUser.getEmail());
							UserDto user = this.userService.getUserByEmail(registerNewUser.getEmail());
							
							return response(true,"Fetch successfully", user,userDetail,0);
						} 
						
						// SHOPKEEPER
						else if(requst.getRoleId() == 2) {
							
							// 1. Create user
							dto.setRequest(1);
							dto.setIsActive(true);
							dto.setRating(5);
							dto.setSubscription(new Date().getTime());
							
							UserDto registerUserDto = registerUserDto(dto, requst.getRoleId());
							
							return response(false,"Thanks for your interest towards Murti Art Application, Our team will contact you soon or You can directly call them! Thanks for your patience!", registerUserDto,null,0);
						}
						
						// CUSTOMER
						else {
							
							// 1. Create user
							dto.setRequest(0);
							dto.setIsActive(true);
							dto.setRating(5);
							dto.setSubscription(new Date().getTime());
							
							UserDto registerNewUser = registerUserDto(dto, requst.getRoleId());
							UserDetails userDetail = this.detailsService.loadUserByUsername(registerNewUser.getEmail());
							UserDto user = this.userService.getUserByEmail(registerNewUser.getEmail());
							
							return response(true,"Fetch successfully", user,userDetail,0);
						}
					} 
		    		
		    		// USER EMAIL AND USERNAME SHOULD BE SAME
		    		else 
		    			return response(false, "Please enter valid username and email id", null,null,3);
	    		}
	    		
	    		// USER WANT TO REGISTER BUT DID NOT SEND USER ROLE ID
	    	else  
	    		return response(false, "Please send user infroramtion and role id for register with us!", null,null,1);
	    	}  

	    	// USER WANT TO REGISTER BUT DID NOT SEND USER DATA
			else  
				return response(false, "Please send user infroramtion and role id for register with us!", null,null,2);
	    }
	}
	
	
	private GenericApiRespons<JwtAuthResponse> response(Boolean isSuccess, String message, UserDto dto, UserDetails userDetail,Integer code) {
		JwtAuthResponse authResponse = new JwtAuthResponse();
		authResponse.setToken(userDetail == null? null : getToken(userDetail));
		authResponse.setUser(dto);
		
		return   JsonKeysManageGlobally.standaredResponseBuilder(authResponse,message,isSuccess,code);
	}
	
	
	private String getToken(UserDetails userDetail) {
	return this.jwtTokenHelper.generateToken(userDetail);
	}
	
	private UserDto registerUserDto(UserDto dto, Integer roleId) {
		return   this.userService.registerUser(dto, roleId);
	}
}
