package com.murtiart.variant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murtiart.attribute.Attribute;
import com.murtiart.exceptions.ResourceNotFoundException;
import com.murtiart.images.Image;
import com.murtiart.product.Product;
import com.murtiart.product.ProductRepository;

@Service
public class VariantServiceImple implements VariantService {
	
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private VariantRepository variantRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public List<VariantDto> createVariant(List<VariantDto> dtos, Integer productId) {
		Product product  = this.productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "Id", productId));
		
		List<Variant> variants = new ArrayList<>();
		
		for (int i = 0; i < dtos.size(); i++) {
			
			VariantDto dto = dtos.get(i);
			
			Variant variant = this.modelMapper.map(dto	, Variant.class);
			variant.setVariantid(variant.getVariantid() <0? null : variant.getVariantid());
			variant.setProduct(product);

			List<Attribute> attributes = variant.getAttributes();
			for (int j = 0; j < attributes.size(); j++) {
				Attribute attribute = attributes.get(j);
				attribute.setVariant(variant);
				attributes.set(j, attribute);
			}
			
			List<Image> images = variant.getImages();
			for (int j = 0; j < images.size(); j++) {
				Image image = images.get(j);
				image.setVariant(variant);
				images.set(j, image);
			}
			
			variant.setAttributes(attributes);
			variant.setImages(images);
			variants.add(variant);
			
		}
	    List<Variant> saveAll = this.variantRepository.saveAll(variants);
	    List<VariantDto> collect = saveAll.stream().map((p) -> this.modelMapper.map(p, VariantDto.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public VariantDto updateVariant(VariantDto dto, Integer variantId) {

			Variant variant = this.variantRepository.findById(variantId).orElseThrow(() -> new ResourceNotFoundException("Variant", "id",variantId));
		
			variant.setMrp(dto.getMrp());
			variant.setOrderLimit(dto.getOrderLimit());
			variant.setOutOfStock(dto.getOutOfStock());; 
			variant.setQuantity(dto.getQuantity());
			variant.setSoldquanitity(dto.getSoldquanitity());
			variant.setSp(dto.getSp());
			variant.setRating(dto.getRating());
			variant.setAskPrice(dto.getAskPrice());
			variant.setRemove(dto.getRemove());
		
			Variant updatedVariant = this.variantRepository.save(variant);
			return this.modelMapper.map(updatedVariant, VariantDto.class);
	}

	@Override
	public void deleteVariant(Integer variantId, Integer isRemove) {
		Variant variant = this.variantRepository.findById(variantId).orElseThrow(() -> new ResourceNotFoundException("Variant", "id",variantId));
		variant.setRemove(isRemove==1);
		this.variantRepository.save(variant);
	}
}
