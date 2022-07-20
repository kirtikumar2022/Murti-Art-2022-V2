package com.murtiart.category;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	private Integer categoryid;
	
	@NotEmpty
	private String catDesc;
	
	@NotEmpty
	private String catName;
	
	@NotEmpty
	private Boolean choosable;
	
	@NotEmpty
	private Boolean remove;
	
	@NotEmpty
	private Boolean murti;
	
	@NotEmpty
	private String image;
	
}
