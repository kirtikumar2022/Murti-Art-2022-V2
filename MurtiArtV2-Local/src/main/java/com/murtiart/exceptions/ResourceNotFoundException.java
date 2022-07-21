package com.murtiart.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
	
	String resourceName;
	String resourceFiledName;
	long filedValue;
	public ResourceNotFoundException(String resourceName, String resourceFiledName, long filedValue) {
		super(String.format("%s not found with %s : %s", resourceName,resourceFiledName,filedValue));
		this.resourceName = resourceName;
		this.resourceFiledName = resourceFiledName;
		this.filedValue = filedValue;
	}
}
