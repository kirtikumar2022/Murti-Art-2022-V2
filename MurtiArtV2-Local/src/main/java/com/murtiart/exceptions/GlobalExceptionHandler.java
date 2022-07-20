package com.murtiart.exceptions;
 

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.murtiart.utils.ApiResponse;


// @RestControllerAdvice this help to handle global level exception handling
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class) // <- This class is our custom exception class need to set every excpetion handling state and that exception catch then this below method will call so once get any type of exception this below response get to client 
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
	String message  = ex.getMessage();
	ApiResponse response = new ApiResponse(message,false);
	return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class) 
	public ResponseEntity<Map<String,String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex){
		Map<String,String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			resp.put(fieldName, message);
		});
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}
	 
	
	@ExceptionHandler(ConstraintViolationException.class) 
	public ResponseEntity<Map<String,String>> handleConstrainVoilationException(ConstraintViolationException ex){
		Map<String,String> resp = new HashMap<>();
		ex.getConstraintViolations().forEach(error -> {
			String fieldName = ((FieldError)error).getField();
			String message = error.getMessage();
			resp.put(fieldName, message);
		});
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(DataIntegrityViolationException.class) 
	public ResponseEntity<Map<String,String>> handleDataIntegrityViolationException(DataIntegrityViolationException ex){
		Map<String,String> resp = new HashMap<>();
		 resp.put(ex.getMessage(),ex.getMessage());
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class) 
	public ResponseEntity<Map<String,String>> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex){
		Map<String,String> resp = new HashMap<>();
		 resp.put(ex.getMessage(),ex.getMessage());
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}
	
 
	@ExceptionHandler(UnexpectedTypeException.class) 
	public ResponseEntity<Map<String,String>> handleUnexpectedTypeException(UnexpectedTypeException ex){
		Map<String,String> resp = new HashMap<>();
		 resp.put(ex.getMessage(),ex.getMessage());
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}
}
