package com.murtiart.attribute;

import java.util.List;

import com.murtiart.variant.VariantDto;


public interface AttributeService {
	
	  AttributeDto createData(AttributeDto dto, Integer variantId);
	  
	 List<AttributeDto> createDatas(List<VariantDto> dtos);
		
	  AttributeDto updateData(AttributeDto dto, Integer attributeId);
	
	  AttributeDto deleteData(Integer attributeId, Integer remove);
	
	  AttributeDto getData(Integer attributeId);
	
	  List<AttributeDto> getDatas();
}
