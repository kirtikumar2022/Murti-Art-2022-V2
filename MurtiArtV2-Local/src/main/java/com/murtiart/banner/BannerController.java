package com.murtiart.banner;

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
@RequestMapping("/api/banners")
public class BannerController {

	@Autowired
	private BannerService bannerService;
	
	
	@PostMapping("")
	public  GenericApiRespons<BannerDto> createBanner(@RequestBody BannerDto dto){
		BannerDto data = this.bannerService.createData(dto);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.CREATED, JsonKeysManageGlobally.OK);
	}
	
	
	@PutMapping("/{id}")
	public  GenericApiRespons<BannerDto> updateBanner(@RequestBody BannerDto dto, @PathVariable Integer id) {
		BannerDto data = this.bannerService.updateData(dto, id);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.UPDATED, JsonKeysManageGlobally.OK);
	}
	
	
	@GetMapping("/{id}")
	public  GenericApiRespons<BannerDto> getBanner(@PathVariable Integer id){
		BannerDto data = this.bannerService.getData(id);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.FOUND, JsonKeysManageGlobally.OK);
	}
	
	
	@DeleteMapping("/{id}/remove/{option}")
	public  GenericApiRespons<BannerDto> deleteBanner(@PathVariable Integer id,@PathVariable Integer option){
		BannerDto data = this.bannerService.deleteData(id,option);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.CREATED, JsonKeysManageGlobally.OK);
	}	
	
	
	@GetMapping("")
	public  GenericApiRespons<List<BannerDto>> getBanners(){
		List<BannerDto> list = this.bannerService.getDatas();
		return JsonKeysManageGlobally.standaredResponseBuilder(list,StringConstants.FOUND, JsonKeysManageGlobally.OK);
	}	
}
