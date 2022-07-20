package com.murtiart.variant;

import java.util.List;

public interface VariantService {
	
	List<VariantDto> createVariant(List<VariantDto> dtos, Integer productId);
	
	VariantDto updateVariant(VariantDto dto, Integer variantId);
	
	void deleteVariant(Integer variantId, Integer isRemove);
}
