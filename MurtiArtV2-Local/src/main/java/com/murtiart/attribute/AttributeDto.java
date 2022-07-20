package com.murtiart.attribute;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class AttributeDto {
	
	private Integer attributeid;
	private String key; 
	private String value; 
	private Boolean remove; 
}
