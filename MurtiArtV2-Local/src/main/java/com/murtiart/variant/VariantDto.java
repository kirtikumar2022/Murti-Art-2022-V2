package com.murtiart.variant;

import java.util.ArrayList;
import java.util.List;

import com.murtiart.attribute.AttributeDto;
import com.murtiart.images.ImageDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class VariantDto {
	
	private Integer variantid;
	private Long mrp;
	private Integer orderLimit;
	private Boolean outOfStock; 
	private Integer  soldquanitity;
	private Integer quantity;
	private Long sp;
	private Integer rating;
	private Boolean askPrice;
	private Boolean remove;
	private List<AttributeDto> attributes = new  ArrayList<>();
	private List<ImageDto> images =   new  ArrayList<>();
}
