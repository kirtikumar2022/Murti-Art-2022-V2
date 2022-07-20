package com.murtiart.product;


public interface ProductService {

	ProductDto createProduct(ProductDto dto, Integer userId, Integer categoryId, Integer addressId); 
	
	ProductDto updateProduct(ProductDto dto, Integer productId);
	
	ProductDto deleteProduct(Integer productId , Integer isRemove);
	
	ProductDto getProductById(Integer productId);

	
	ProductResponse getAllProduct(Integer pageNumber , Integer pageSize, String sortBy, /*String sortDirection,*/Integer categoryId,Integer userId,String keyword);
	
//	ProductResponse getProductByCategory(Integer pageNumber , Integer pageSize, String sortBy, String sortDirection,Integer categoryId);
	
//	ProductResponse getProductByUser(Integer pageNumber , Integer pageSize, String sortBy, String sortDirection,Integer userId);
	
//	ProductResponse searchProduct(Integer pageNumber , Integer pageSize, String sortBy, String sortDirection,String keyword);
}