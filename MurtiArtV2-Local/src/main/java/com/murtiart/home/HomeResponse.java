package com.murtiart.home;

import java.util.List;

import com.murtiart.banner.BannerDto;
import com.murtiart.category.CategoryDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class HomeResponse {
	
	private List<BannerDto> banners;
	
	private List<CategoryDto> categories;

}
