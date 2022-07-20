package com.murtiart.utils;

public class JsonKeysManageGlobally {
	
	public final static String MESSAGE = "message";
	public final static String STATUS = "status";
	public final static String ERROR = "error";
	public final static String OK = "ok";
	public final static String RESPONSE = "response";
	public final static String DATA = "data";
	public final static String MORE = "more";
	public final static String ACTION = "action";
	
	// TODO This is for Home 
	public final static String LIST1 = "list1";
	public final static String LIST2 = "list2";
	
	
	public static  <T>GenericApiRespons<T> standaredResponseBuilder(T label, String moreMessage, String moreStatus) {
		
		GenericApiRespons<T>  genericResponse = new GenericApiRespons<T>();
		
		GenericMore genericMore =  new GenericMore();
		genericMore.setMessage(moreMessage);
//		genericMore.setStatus(moreStatus);
		
		genericResponse.setData(label);
		genericResponse.setMore(genericMore);
		
		return genericResponse;
	}
	

	public static  <T>GenericApiRespons<T> standaredResponseBuilder(T label, String moreMessage, Boolean moreStatus) {
		
		GenericApiRespons<T>  genericResponse = new GenericApiRespons<T>();
		
		GenericMore genericMore =  new GenericMore();
		genericMore.setMessage(moreMessage);
		
		genericResponse.setData(label);
		genericResponse.setMore(genericMore);
		genericMore.setStatus(moreStatus);
		
		return genericResponse;
	}
	

	// List of code meaning 
	// 0 = everything is good
	// 1 = roleId not send 
	// 2 = user data not send for registration 
	// 3 = usename and User object email id not same
	// 4 = login user don't have valid role
	
	public static  <T>GenericApiRespons<T> standaredResponseBuilder(T label, String moreMessage, Boolean status, Integer code) {
		
		GenericApiRespons<T>  genericResponse = new GenericApiRespons<T>();
		
		GenericMore genericMore =  new GenericMore();
		genericMore.setMessage(moreMessage);
		
		genericResponse.setData(label);
		genericResponse.setMore(genericMore);
		genericMore.setStatus(status);
		genericMore.setCode(code);
		
		return genericResponse;
	}



}