package com.murtiart.faviourte;

import java.util.List;

import com.murtiart.product.ProductResponse;

public interface FavouriteService {

	FavouriteDto createFavourite(Integer userId, Integer productId); 
	
	FavouriteDto getFavouriteById(Integer productId, Integer userId);
	
	ProductResponse getProductByUser(Integer pageNumber , Integer pageSize, String sortBy, Integer userId);
	
}