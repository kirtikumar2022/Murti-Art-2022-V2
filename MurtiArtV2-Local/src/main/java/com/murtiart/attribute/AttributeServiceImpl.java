package com.murtiart.attribute;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murtiart.exceptions.ResourceNotFoundException;
import com.murtiart.images.Image;
import com.murtiart.images.ImageDto;
import com.murtiart.product.Product;
import com.murtiart.product.ProductRepository;
import com.murtiart.product.ProductResponse;
import com.murtiart.variant.Variant;
import com.murtiart.variant.VariantDto;
import com.murtiart.variant.VariantRepository;

@Service
public class AttributeServiceImpl implements AttributeService {
	
	@Autowired
	private AttributeRepository attributeRepository;
	
	@Autowired
	private VariantRepository  variantRepository;

	@Autowired
	private ProductRepository  productRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public AttributeDto createData(AttributeDto dto, Integer variantId) {
		Variant variant  = this.variantRepository.findById(variantId).orElseThrow(() -> new ResourceNotFoundException("Varient", "Id", variantId));
		Attribute attribute = this.modelMapper.map(dto, Attribute.class);
		attribute.setVariant(variant);
		Attribute addedAttribute  = this.attributeRepository.save(attribute);
		return this.modelMapper.map(addedAttribute, AttributeDto.class);
	}

	@Override
	public AttributeDto updateData(AttributeDto dto, Integer attributeId) {
		Attribute attribute = this.attributeRepository.findById(attributeId).orElseThrow(() -> new ResourceNotFoundException("Attribute", "id",attributeId));
		attribute.setKey(dto.getKey());
		attribute.setValue(dto.getValue());
		attribute.setRemove(dto.getRemove());
		Attribute saveAttribute = this.attributeRepository.save(attribute);
		return modelMapper.map(saveAttribute, AttributeDto.class);
	}

	@Override
	public AttributeDto deleteData(Integer attributeId, Integer remove) {
		Attribute attribute = this.attributeRepository.findById(attributeId).orElseThrow(() -> new ResourceNotFoundException("Attribute","id",attributeId));
		attribute.setRemove(remove==1);
		Attribute saveAttribute = this.attributeRepository.save(attribute);
		return modelMapper.map(saveAttribute, AttributeDto.class);
	}

	@Override
	public AttributeDto getData(Integer attributeId) {
		Attribute attribute = this.attributeRepository.findById(attributeId).orElseThrow(() -> new ResourceNotFoundException("Attribute","id",attributeId));
		return this.modelMapper.map(attribute, AttributeDto.class);
	}

	@Override
	public List<AttributeDto> getDatas() {
		return  this.attributeRepository.findAll().stream().map((data) -> this.modelMapper.map(data, AttributeDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<AttributeDto> createDatas(List<VariantDto> dtos) {

		List<Attribute> all = new ArrayList<>();
		
		for(int i = 0; i < dtos.size();i++) {
			
			VariantDto variantDto = dtos.get(i);
			Variant variant  = this.variantRepository.findById(variantDto.getVariantid()).orElseThrow(() -> new ResourceNotFoundException("Varient", "Id", variantDto.getVariantid()));
		    
			List<Attribute> attributes = new ArrayList<>();
			
	        List<AttributeDto> attributesDto = variantDto.getAttributes();

			for (int j = 0; j < attributesDto.size(); j++) {
				AttributeDto imag = attributesDto.get(j);
				
				 Attribute attribute = this.modelMapper.map(imag, Attribute.class);
				 attribute.setAttributeid(imag.getAttributeid() <0? null : imag.getAttributeid());
				 
				 attribute.setVariant(variant);
			    attributes.add(attribute);
			
			}
			
			List<Attribute> addedImage = this.attributeRepository.saveAll(attributes);
			all.addAll(addedImage);
		}
		
		List<AttributeDto> collect = all.stream().map(d -> this.modelMapper.map(d, AttributeDto.class)).collect(Collectors.toList());
		return collect;
	}

}
