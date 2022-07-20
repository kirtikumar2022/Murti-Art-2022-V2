package com.murtiart.units;

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
@RequestMapping("/api/units")
public class UnitsController {
	
	@Autowired
	private UnitsService unitsService;
	
	@PostMapping("")
	public GenericApiRespons<UnitsDto> createUnit(@RequestBody UnitsDto dto){
		UnitsDto data = this.unitsService.createData(dto);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.CREATED, true,0);
	}
	
	@PutMapping("/{id}")
	public GenericApiRespons<UnitsDto>  updateUnit(@RequestBody UnitsDto dto, @PathVariable Integer id) {
		UnitsDto data = this.unitsService.updateData(dto, id);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.UPDATED,true,0);
	}
	
	@GetMapping("/{id}")
	public GenericApiRespons<UnitsDto>  getUnit(@PathVariable Integer id){
		UnitsDto data = this.unitsService.getData(id);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.FOUND, true,0);
	}
	
	@DeleteMapping("/{id}/remove/{option}")
	public GenericApiRespons<UnitsDto>  deleteAttribute(@PathVariable Integer id,@PathVariable Integer option){
		UnitsDto data = this.unitsService.deleteData(id, option);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.DELETED, true,0);
	}	
	
	@GetMapping("")
	public GenericApiRespons<List<UnitsDto>> getAttribute(){
		List<UnitsDto> list = this.unitsService.getDatas();
		return JsonKeysManageGlobally.standaredResponseBuilder(list,StringConstants.FOUND, true,0);
	}
}
