package com.murtiart.about;

import java.util.List;

public interface AboutUsService {

	  AboutUsDto createData(AboutUsDto dto);
		
	  AboutUsDto updateData(AboutUsDto dto, Integer aboutusId);
	
	  AboutUsDto deleteData(Integer aboutusId, Integer remove);
	
	  AboutUsDto getData(Integer aboutusId);
	
	  List<AboutUsDto> getDatas();

}
