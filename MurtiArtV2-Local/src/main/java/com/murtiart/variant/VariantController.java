package com.murtiart.variant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.murtiart.utils.ApiResponse;
import com.murtiart.utils.GenericApiRespons;
import com.murtiart.utils.JsonKeysManageGlobally;

@RestController
@RequestMapping("/api/variants/")
public class VariantController {

	
	@Autowired
	private VariantService variantService;
	
	@PostMapping("/product/{productId}")
	public GenericApiRespons<List<VariantDto>> createVariant(@RequestBody List<VariantDto> dtos, @PathVariable Integer productId){
		List<VariantDto> createdVariant  = this.variantService.createVariant(dtos, productId);
		return JsonKeysManageGlobally.standaredResponseBuilder(createdVariant,StringConstants.CREATED, true);
	}

	
	@DeleteMapping("/{variantId}/remove/{option}")
	public GenericApiRespons<ApiResponse> deleteVariant(@PathVariable Integer variantId,@PathVariable Integer option){
	    this.variantService.deleteVariant(variantId, option);
		return JsonKeysManageGlobally.standaredResponseBuilder(new ApiResponse(option == 0 ? "Added":"Deleted",true),StringConstants.DELETED, true);
	}
	
	@PutMapping("/{productId}")
	public GenericApiRespons<VariantDto> updateVariant(@RequestBody VariantDto dto, @PathVariable Integer productId){
	    VariantDto updatedVariant = this.variantService.updateVariant(dto, productId);
		return JsonKeysManageGlobally.standaredResponseBuilder(updatedVariant,StringConstants.UPDATED, true);
	}
}
