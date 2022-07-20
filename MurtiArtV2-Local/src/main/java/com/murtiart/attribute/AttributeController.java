package com.murtiart.attribute;

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
import com.murtiart.variant.VariantDto;

@RestController
@RequestMapping("/api/attribute")
public class AttributeController {
	
	
	@Autowired
	private AttributeService attributeService;
	
	@PostMapping("/variant/{variantId}")
	public GenericApiRespons<AttributeDto> createAttribute(@RequestBody AttributeDto dto, @PathVariable Integer variantId){
		AttributeDto data = this.attributeService.createData(dto,variantId);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.CREATED, JsonKeysManageGlobally.OK);
	}
	

	@PostMapping("/updates")
	public GenericApiRespons<List<AttributeDto>> createAttributes(@RequestBody List<VariantDto> dto){
		List<AttributeDto> data = this.attributeService.createDatas(dto);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.CREATED, JsonKeysManageGlobally.OK);
	}
	
	
	
	@PutMapping("/{id}")
	public GenericApiRespons<AttributeDto>  updateAttribute(@RequestBody AttributeDto dto, @PathVariable Integer id) {
		AttributeDto data = this.attributeService.updateData(dto, id);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.UPDATED, JsonKeysManageGlobally.OK);
	}
	
	@GetMapping("/{id}")
	public GenericApiRespons<AttributeDto>  getAttribute(@PathVariable Integer id){
		AttributeDto data = this.attributeService.getData(id);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.FOUND, JsonKeysManageGlobally.OK);
	}
	
	@DeleteMapping("/{id}/remove/{option}")
	public GenericApiRespons<AttributeDto>  deleteAttribute(@PathVariable Integer id,@PathVariable Integer option){
		AttributeDto data = this.attributeService.deleteData(id, option);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.DELETED, JsonKeysManageGlobally.OK);
	}	
	
	@GetMapping("")
	public GenericApiRespons<List<AttributeDto>> getAttribute(){
		List<AttributeDto> list = this.attributeService.getDatas();
		return JsonKeysManageGlobally.standaredResponseBuilder(list,StringConstants.FOUND, JsonKeysManageGlobally.OK);
	}
}
