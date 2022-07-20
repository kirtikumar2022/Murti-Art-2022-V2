package com.murtiart.size;

import java.util.List;

public interface MurtiSizeService {
	
	  MurtiSizeDto createData(MurtiSizeDto dto);
		
	  MurtiSizeDto updateData(MurtiSizeDto dto, Integer murtiSizeId);
	
	  MurtiSizeDto deleteData(Integer murtiSizeId, Integer remove);
	
	  MurtiSizeDto getData(Integer murtiSizeId);
	
	  List<MurtiSizeDto> getDatas();
}
