package com.murtiart.images;

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
@RequestMapping("/api/images/")
public class ImageController {

	@Autowired
	private ImageService imageService;
	
	@PostMapping("/variant/{variantId}")
	public GenericApiRespons<ImageDto> createImage(@RequestBody ImageDto dto, @PathVariable Integer variantId){
		ImageDto data = this.imageService.createData(dto,variantId);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.CREATED, JsonKeysManageGlobally.OK);
	}
	
	@PostMapping("/updateimages")
	public GenericApiRespons<List<ImageDto>> createImages(@RequestBody List<VariantDto> dto){
		List<ImageDto> data = this.imageService.createDatas(dto);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.CREATED, JsonKeysManageGlobally.OK);
	}
	
	
	
	@PutMapping("/{id}")
	public GenericApiRespons<ImageDto>  updateImage(@RequestBody ImageDto dto, @PathVariable Integer id) {
		ImageDto data = this.imageService.updateData(dto, id);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.UPDATED, JsonKeysManageGlobally.OK);
	}
	
	@GetMapping("/{id}")
	public GenericApiRespons<ImageDto>  getImage(@PathVariable Integer id){
		ImageDto data = this.imageService.getData(id);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.FOUND, JsonKeysManageGlobally.OK);
	}
	
	@DeleteMapping("/{id}/remove/{option}")
	public GenericApiRespons<ImageDto>  deleteImage(@PathVariable Integer id,@PathVariable Integer option){
		ImageDto data = this.imageService.deleteData(id, option);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.DELETED, JsonKeysManageGlobally.OK);
	}	
	
	@GetMapping("")
	public GenericApiRespons<List<ImageDto>> getImages(){
		List<ImageDto> list = this.imageService.getDatas();
		return JsonKeysManageGlobally.standaredResponseBuilder(list,StringConstants.FOUND, JsonKeysManageGlobally.OK);
	}
}
