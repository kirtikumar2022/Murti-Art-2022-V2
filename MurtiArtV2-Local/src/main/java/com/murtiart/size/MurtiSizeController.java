package com.murtiart.size;

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
@RequestMapping("/api/murtisize")
public class MurtiSizeController {

	@Autowired
	private MurtiSizeService murtiSizeService;
	
	@PostMapping("")
	public GenericApiRespons<MurtiSizeDto> createMurtiSize(@RequestBody MurtiSizeDto dto){
		MurtiSizeDto data = this.murtiSizeService.createData(dto);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.CREATED, JsonKeysManageGlobally.OK);
	}
	
	@PutMapping("/{id}")
	public GenericApiRespons<MurtiSizeDto>  updateMurtiSize(@RequestBody MurtiSizeDto dto, @PathVariable Integer id) {
		MurtiSizeDto data = this.murtiSizeService.updateData(dto, id);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.UPDATED, JsonKeysManageGlobally.OK);
	}
	
	@GetMapping("/{id}")
	public GenericApiRespons<MurtiSizeDto>  getMurtiSize(@PathVariable Integer id){
		MurtiSizeDto data = this.murtiSizeService.getData(id);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.FOUND, JsonKeysManageGlobally.OK);
	}
	
	@DeleteMapping("/{id}/remove/{option}")
	public GenericApiRespons<MurtiSizeDto>  deleteMurtiSize(@PathVariable Integer id,@PathVariable Integer option){
		MurtiSizeDto data = this.murtiSizeService.deleteData(id, option);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.DELETED, JsonKeysManageGlobally.OK);
	}	
	
	@GetMapping("")
	public GenericApiRespons<List<MurtiSizeDto>> getMurtiSizes(){
		List<MurtiSizeDto> list = this.murtiSizeService.getDatas();
		return JsonKeysManageGlobally.standaredResponseBuilder(list,StringConstants.FOUND, JsonKeysManageGlobally.OK);
	}
}
