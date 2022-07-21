package com.murtiart.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.murtiart.address.AddressDto;
import com.murtiart.category.Category;
import com.murtiart.user.User;

public interface ProductRepository  extends JpaRepository<Product, Integer>{
	
	List<Product> findByUser(User user);
	
	List<Product> findByCategory(Category category);
	
	List<Product> findByProductNameContaining(String productName);
	// if searching not working above code then use below code
//	@Query("select p from products  p where p.product_name like :key")
//	List<Product> searchByProductName(@Param("key") String productName);
	
	List<Product> findByAddress(AddressDto address);
}
