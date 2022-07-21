package com.murtiart.product;


import java.util.HashSet;
import java.util.Set;

import com.murtiart.address.AddressDto;
import com.murtiart.category.CategoryDto;
import com.murtiart.faviourte.FavouriteDto;
import com.murtiart.user.UserDto;
import com.murtiart.variant.VariantDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
	private Integer productid;
	private String productDesc;
	private String productName;
	private Boolean remove;
	private CategoryDto category;
	private AddressDto address;
	private FavouriteDto favourite;
	private UserDto user;
	private Set<VariantDto> variants = new  HashSet<>();
}
