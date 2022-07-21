package com.murtiart.images;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ImageDto {
	
	private Integer imageid;
	private String key; 
	private String value; 
	private Boolean remove; 
}
