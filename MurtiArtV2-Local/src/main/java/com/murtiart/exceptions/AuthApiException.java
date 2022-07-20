package com.murtiart.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.murtiart.auth.JwtAuthResponse;

public class AuthApiException  extends RuntimeException{

	public AuthApiException(String message) {
		super(message);
	}

	public AuthApiException() {
		super();
	}
	
	@ExceptionHandler(AuthApiException.class) // <- This class is our custom exception class need to set every excpetion handling state and that exception catch then this below method will call so once get any type of exception this below response get to client 
	public ResponseEntity<JwtAuthResponse> handleApiException(AuthApiException ex){
	String message  = ex.getMessage();
	JwtAuthResponse response = new JwtAuthResponse();
//	response.setSuccess(false);
//	response.setMessage(message);
	return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
}
