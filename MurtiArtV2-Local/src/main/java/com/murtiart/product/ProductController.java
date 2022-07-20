package com.murtiart.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.murtiart.config.AppConstants;
import com.murtiart.utils.GenericApiRespons;
import com.murtiart.utils.JsonKeysManageGlobally;

@RestController
@RequestMapping("/api/")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/user/{userId}/category/{categoryId}/address/{addressId}")
	public GenericApiRespons<ProductDto> createProduct(@RequestBody ProductDto dto, 
			@PathVariable Integer userId, @PathVariable Integer categoryId, @PathVariable Integer addressId){
		ProductDto data = this.productService.createProduct(dto, userId, categoryId,addressId);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.CREATED, JsonKeysManageGlobally.OK);
	}
	
//
//	@GetMapping("/category/{categoryId}/product")
//	public ResponseEntity<ProductResponse>  getProductsByCategory(
//			@RequestParam(value ="pageNumber", defaultValue =  AppConstants.PAGE_NUMBER, required = false) Integer pageNumber, 
//			@RequestParam(value ="pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
//			@RequestParam(value ="sortBy", defaultValue =AppConstants.SORT_BY, required = false) String sortBy,
//			@RequestParam(value ="sortDirection", defaultValue = AppConstants.SORT_DIR, required = false) String sortDirection,
//			@PathVariable Integer categoryId){
//		
//		ProductResponse response = this.productService.getProductByCategory(pageNumber,pageSize,sortBy,sortDirection,categoryId);
//		return new ResponseEntity<>(response,HttpStatus.OK);
//	}

	// product?pageNumber=1&pageSize
	@GetMapping("/product")
	public GenericApiRespons<ProductResponse> getProducts(
			@RequestParam(value ="pageNumber", defaultValue =  AppConstants.PAGE_NUMBER, required = false) Integer pageNumber, 
			@RequestParam(value ="pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value ="sortBy", defaultValue =AppConstants.SORT_BY, required = false) String sortBy,
//			@RequestParam(value ="sortDirection", defaultValue = AppConstants.SORT_DIR, required = false) String sortDirection,
			@RequestParam(value ="categoryId", defaultValue = AppConstants.CAT_ID, required = false) Integer categoryId,
			@RequestParam(value ="userId", defaultValue = AppConstants.USER_ID, required = false) Integer userId,
			@RequestParam(value ="keyword", defaultValue = "", required = false) String keyword) {
		ProductResponse response = this.productService.getAllProduct( pageNumber ,  pageSize,  sortBy,  /*sortDirection, */categoryId, userId, keyword);
		return JsonKeysManageGlobally.standaredResponseBuilder(response,response.getContent().size()>0 ? StringConstants.FOUND :StringConstants.NOT_FOUND, true);
	}
	
//	@GetMapping("/product/search/{keyword}")
//	public ResponseEntity<ProductResponse> searchProducts(
//			@RequestParam(value ="pageNumber", defaultValue =  AppConstants.PAGE_NUMBER, required = false) Integer pageNumber, 
//			@RequestParam(value ="pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
//			@RequestParam(value ="sortBy", defaultValue =AppConstants.SORT_BY, required = false) String sortBy,
//			@RequestParam(value ="sortDirection", defaultValue = AppConstants.SORT_DIR, required = false) String sortDirection,
//			@PathVariable String keyword) {
//		ProductResponse response = this.productService.searchProduct(pageNumber,pageSize,sortBy,sortDirection,keyword);
//		return new ResponseEntity<>(response,HttpStatus.OK);
//	}
	
	
//	@GetMapping("/user/{userId}/product")
//	public ResponseEntity<ProductResponse> getProductsByUser(
//			@RequestParam(value ="pageNumber", defaultValue =  AppConstants.PAGE_NUMBER, required = false) Integer pageNumber, 
//			@RequestParam(value ="pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
//			@RequestParam(value ="sortBy", defaultValue =AppConstants.SORT_BY, required = false) String sortBy,
//			@RequestParam(value ="sortDirection", defaultValue = AppConstants.SORT_DIR, required = false) String sortDirection,
//			@PathVariable Integer userId){
//		ProductResponse response = this.productService.getProductByUser(pageNumber,pageSize,sortBy,sortDirection,userId);
//		return new ResponseEntity<>(response,HttpStatus.OK);
//	}
	
	@GetMapping("/product/{productId}")
	public GenericApiRespons<ProductDto> getSingleProduct(@PathVariable Integer productId){
	 ProductDto data = this.productService.getProductById(productId);
	return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.FOUND, JsonKeysManageGlobally.OK);
	}

	
	@DeleteMapping("/product/{productId}/remove/{option}")
	public GenericApiRespons<ProductDto> deleteProduct(@PathVariable Integer productId,@PathVariable Integer option){
	    ProductDto data = this.productService.deleteProduct(productId,option);
	    return JsonKeysManageGlobally.standaredResponseBuilder(data, option == 0 ?StringConstants.CREATED:StringConstants.DELETED, JsonKeysManageGlobally.OK);
	}
	
	@PutMapping("/product/{productId}")
	public GenericApiRespons<ProductDto> updateProduct(@RequestBody ProductDto dto, @PathVariable Integer productId){
	    ProductDto data = this.productService.updateProduct( dto, productId);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.UPDATED, JsonKeysManageGlobally.OK);
	}
	

	
}
