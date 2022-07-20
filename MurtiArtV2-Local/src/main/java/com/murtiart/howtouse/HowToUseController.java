package com.murtiart.howtouse;

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
@RequestMapping("/api/howtouse")
public class HowToUseController {
	
	@Autowired
	HowToUseService howToUseRepository;
	
	@PostMapping("")
	public GenericApiRespons<HowToUseDto> createHowToUse(@RequestBody HowToUseDto dto){
		HowToUseDto data = this.howToUseRepository.createData(dto);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.CREATED, JsonKeysManageGlobally.OK);
	}
	
	@PutMapping("/{id}")
	public GenericApiRespons<HowToUseDto>  updateHowToUse(@RequestBody HowToUseDto dto, @PathVariable Integer id) {
		HowToUseDto data = this.howToUseRepository.updateData(dto, id);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.UPDATED, JsonKeysManageGlobally.OK);
	}
	
	@GetMapping("/{id}")
	public GenericApiRespons<HowToUseDto>  getHowToUse(@PathVariable Integer id){
		HowToUseDto data = this.howToUseRepository.getData(id);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.FOUND, JsonKeysManageGlobally.OK);
	}
	
	@DeleteMapping("/{id}/remove/{option}")
	public GenericApiRespons<HowToUseDto>  deleteHowToUse(@PathVariable Integer id,@PathVariable Integer option){
		HowToUseDto data = this.howToUseRepository.deleteData(id, option);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.DELETED, JsonKeysManageGlobally.OK);
	}	
	
	@GetMapping("")
	public GenericApiRespons<List<HowToUseDto>> getHowToUse(){
		List<HowToUseDto> list = this.howToUseRepository.getDatas();
		return JsonKeysManageGlobally.standaredResponseBuilder(list,StringConstants.FOUND, JsonKeysManageGlobally.OK);
	}
}
