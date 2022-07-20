package com.murtiart.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.murtiart.utils.GenericApiRespons;
import com.murtiart.utils.JsonKeysManageGlobally;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	
	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping("")
	public  GenericApiRespons<CategoryDto> createCategory(@RequestBody CategoryDto dto){
		CategoryDto data = this.categoryService.createData(dto);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.CREATED, JsonKeysManageGlobally.OK);
	}
	
	
	@PutMapping("/{id}")
	public  GenericApiRespons<CategoryDto> updateCategory(@RequestBody CategoryDto dto, @PathVariable Integer id) {
		CategoryDto data = this.categoryService.updateData(dto, id);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.UPDATED, JsonKeysManageGlobally.OK);
	}
	
	
	@GetMapping("/{id}")
	public  GenericApiRespons<CategoryDto> getCategory(@PathVariable Integer id){
		CategoryDto data = this.categoryService.getData(id);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.FOUND, JsonKeysManageGlobally.OK);
	}
	
	
	@DeleteMapping("/{id}/remove/{option}")
	public  GenericApiRespons<CategoryDto> deleteCategory(@PathVariable Integer id,@PathVariable Integer option){
		CategoryDto data = this.categoryService.deleteData(id,option);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.CREATED, JsonKeysManageGlobally.OK);
	}	
	
	
	@GetMapping("")
	public  GenericApiRespons<List<CategoryDto>> getCategorys(){
		List<CategoryDto> list = this.categoryService.getDatas();
		return JsonKeysManageGlobally.standaredResponseBuilder(list,StringConstants.FOUND, JsonKeysManageGlobally.OK);
	}	
}
