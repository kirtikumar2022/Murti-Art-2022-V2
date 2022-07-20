package com.murtiart.variant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.murtiart.product.Product;

public interface VariantRepository extends JpaRepository<Variant, Integer> {
	
  
	List<Variant> findByProduct(Product product);

}
