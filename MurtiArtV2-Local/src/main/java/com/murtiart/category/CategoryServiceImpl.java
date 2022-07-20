package com.murtiart.category;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murtiart.exceptions.ResourceNotFoundException;


@Service
public class CategoryServiceImpl implements CategoryService {
	
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public CategoryDto createData(@Valid  CategoryDto dto) {
		Category category = this.modelMapper.map(dto, Category.class);
		Category addedCategory  = this.categoryRepository.save(category);
		return this.modelMapper.map(addedCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateData(@Valid CategoryDto dto, Integer categoryId) {
		
		Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id",categoryId));
		 
		 category.setCatDesc(dto.getCatDesc());
		 category.setCatName(dto.getCatName());
		 category.setChoosable(dto.getChoosable());
		 category.setImage(dto.getImage());
		 category.setRemove(dto.getRemove());
		 category.setMurti(dto.getMurti());
		 
		 Category saveCategory = this.categoryRepository.save(category);
		
		return modelMapper.map(saveCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto deleteData(Integer categoryId, Integer remove) {
		Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category","id",categoryId));
		category.setRemove(remove==1);
		Category updatedCategory = this.categoryRepository.save(category);
		return this.modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto getData(Integer categoryId) {
		Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category","id",categoryId));
		return this.modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getDatas() {
		return  this.categoryRepository.findAll().stream().map((data) -> this.modelMapper.map(data, CategoryDto.class)).collect(Collectors.toList());
	}
}
