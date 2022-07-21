package com.murtiart.images;

import java.util.List;

import com.murtiart.variant.VariantDto;

public interface ImageService {
	
	  ImageDto createData(ImageDto dto, Integer variantId);
	  
	  List<ImageDto> createDatas(List<VariantDto> dto);
		
	  ImageDto updateData(ImageDto dto, Integer imageId);
	
	  ImageDto deleteData(Integer imageId, Integer remove);
	
	  ImageDto getData(Integer imageId);
	
	  List<ImageDto> getDatas();
}
