package com.murtiart.about;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AboutUsDto {

	private Integer id;
	private String type;
	private String name;
	private String email;
	private String description;
	private Long phone;
	private String gender;
	private Boolean remove;
	private String image;
	
}
