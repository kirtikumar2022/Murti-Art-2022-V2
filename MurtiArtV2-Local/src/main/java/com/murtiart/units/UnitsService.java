package com.murtiart.units;

import java.util.List;


public interface UnitsService {
	
	  UnitsDto createData(UnitsDto dto);
		
	  UnitsDto updateData(UnitsDto dto, Integer unitId);
	
	  UnitsDto deleteData(Integer unitId, Integer remove);
	
	  UnitsDto getData(Integer unitId);
	
	  List<UnitsDto> getDatas();
}
