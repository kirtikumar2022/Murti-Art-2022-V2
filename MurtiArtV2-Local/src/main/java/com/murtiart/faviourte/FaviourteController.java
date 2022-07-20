package com.murtiart.faviourte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.murtiart.config.AppConstants;
import com.murtiart.product.ProductResponse;
import com.murtiart.utils.GenericApiRespons;
import com.murtiart.utils.JsonKeysManageGlobally;

@RestController
@RequestMapping("/api/")
public class FaviourteController {
	
	@Autowired
	private FavouriteService favouriteService;
	
	@PostMapping("/favaction")
	public GenericApiRespons<FavouriteDto> createFav(
			@RequestParam(value ="productId", defaultValue =  AppConstants.DEFAULT, required = true) Integer productId,
			@RequestParam(value ="userId", defaultValue =  AppConstants.DEFAULT, required = true) Integer userId ) {
		FavouriteDto data = this.favouriteService.createFavourite(userId,productId);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.CREATED, true,0);
	}

	// product?pageNumber=1&pageSize
	@GetMapping("/fav")
	public GenericApiRespons<ProductResponse>  getProductsByCategory(
			@RequestParam(value ="pageNumber", defaultValue =  AppConstants.PAGE_NUMBER, required = false) Integer pageNumber, 
			@RequestParam(value ="pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value ="sortBy", defaultValue =AppConstants.FAVOURITE_SORT_BY, required = false) String sortBy,
			@RequestParam(value ="userId", defaultValue = AppConstants.FAVOURITE_DEFAULT_USER, required = false) Integer userId){
		ProductResponse response = this.favouriteService.getProductByUser(pageNumber,pageSize,sortBy,userId);
		return JsonKeysManageGlobally.standaredResponseBuilder(response,StringConstants.CREATED, JsonKeysManageGlobally.OK);
	}
	
	@GetMapping("/selected")
	public GenericApiRespons<FavouriteDto> isSelectedProductFav(
			@RequestParam(value ="productId", defaultValue =  AppConstants.DEFAULT, required = true) Integer productId,
			@RequestParam(value ="userId", defaultValue =  AppConstants.DEFAULT, required = true) Integer userId ) {
	 FavouriteDto data = this.favouriteService.getFavouriteById(productId,userId);
	return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.FOUND, JsonKeysManageGlobally.OK);
	}
	
}
