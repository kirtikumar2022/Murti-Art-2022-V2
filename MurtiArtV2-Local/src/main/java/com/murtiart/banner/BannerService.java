package com.murtiart.banner;

import java.util.List;


public interface BannerService {

	  BannerDto createData(BannerDto dto);
		
	  BannerDto updateData(BannerDto dto, Integer categoryId);
	
	  BannerDto deleteData(Integer categoryId, Integer remove);
	
	  BannerDto getData(Integer categoryId);
	
	  List<BannerDto> getDatas();
}
