package com.murtiart.category;

import java.util.List;

public interface CategoryService {
	
	  CategoryDto createData(CategoryDto dto);
	
	  CategoryDto updateData(CategoryDto dto, Integer bannerId);
	
	  CategoryDto deleteData(Integer bannerId, Integer remove);
	
	  CategoryDto getData(Integer bannerId);
	
	  List<CategoryDto> getDatas();

}
