package com.murtiart.about;

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
@RequestMapping("/api/aboutus")
public class AboutUsController {
	
	@Autowired
	AboutUsService aboutUsService;
	
	@PostMapping("")
	public GenericApiRespons<AboutUsDto> createAboutUs(@RequestBody AboutUsDto dto){
		AboutUsDto data = this.aboutUsService.createData(dto);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.CREATED, JsonKeysManageGlobally.OK);
	}
	
	@PutMapping("/{id}")
	public GenericApiRespons<AboutUsDto>  updateImage(@RequestBody AboutUsDto dto, @PathVariable Integer id) {
		AboutUsDto data = this.aboutUsService.updateData(dto, id);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.UPDATED, JsonKeysManageGlobally.OK);
	}
	
	@GetMapping("/{id}")
	public GenericApiRespons<AboutUsDto>  getImage(@PathVariable Integer id){
		AboutUsDto data = this.aboutUsService.getData(id);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.FOUND, JsonKeysManageGlobally.OK);
	}
	
	@DeleteMapping("/{id}/remove/{option}")
	public GenericApiRespons<AboutUsDto>  deleteImage(@PathVariable Integer id,@PathVariable Integer option){
		AboutUsDto data = this.aboutUsService.deleteData(id, option);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.DELETED, JsonKeysManageGlobally.OK);
	}	
	
	@GetMapping("")
	public GenericApiRespons<List<AboutUsDto>> getImages(){
		List<AboutUsDto> list = this.aboutUsService.getDatas();
		return JsonKeysManageGlobally.standaredResponseBuilder(list,StringConstants.FOUND, JsonKeysManageGlobally.OK);
	}
}
