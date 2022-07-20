package com.murtiart.howtouse;

import java.util.List;

public interface HowToUseService {

	  HowToUseDto createData(HowToUseDto dto);
		
	  HowToUseDto updateData(HowToUseDto dto, Integer howToUseId);
	
	  HowToUseDto deleteData(Integer howToUseId, Integer remove);
	
	  HowToUseDto getData(Integer howToUseId);
	
	  List<HowToUseDto> getDatas();

}
