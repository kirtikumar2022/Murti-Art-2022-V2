package com.murtiart.images;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murtiart.exceptions.ResourceNotFoundException;
import com.murtiart.variant.Variant;
import com.murtiart.variant.VariantDto;
import com.murtiart.variant.VariantRepository;

@Service
public class ImageServiceImpl  implements ImageService{
	
	@Autowired
	private ImageRepository imageRepository;
	
	
	@Autowired
	private VariantRepository  variantRepository;
	
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ImageDto createData(ImageDto dto, Integer variantId) {
		Variant variant  = this.variantRepository.findById(variantId).orElseThrow(() -> new ResourceNotFoundException("Varient", "Id", variantId));
		Image attribute = this.modelMapper.map(dto, Image.class);
		attribute.setVariant(variant);
		Image addedImage = this.imageRepository.save(attribute);
		return this.modelMapper.map(addedImage, ImageDto.class);
	}

	@Override
	public ImageDto updateData(ImageDto dto, Integer imageId) {
		Image image = this.imageRepository.findById(imageId).orElseThrow(() -> new ResourceNotFoundException("Image", "id",imageId));
		image.setKey(dto.getKey());
		image.setValue(dto.getValue());
		image.setRemove(dto.getRemove());
		Image saveImage = this.imageRepository.save(image);
		return modelMapper.map(saveImage, ImageDto.class);
	}

	@Override
	public ImageDto deleteData(Integer imageId, Integer remove) {
		Image image = this.imageRepository.findById(imageId).orElseThrow(() -> new ResourceNotFoundException("Image","id",imageId));
		image.setRemove(remove==1);
		Image saveImage = this.imageRepository.save(image);
		return modelMapper.map(saveImage, ImageDto.class);
	}

	@Override
	public ImageDto getData(Integer imageId) {
		Image image = this.imageRepository.findById(imageId).orElseThrow(() -> new ResourceNotFoundException("Image","id",imageId));
		return this.modelMapper.map(image, ImageDto.class);
	}

	@Override
	public List<ImageDto> getDatas() {
		return  this.imageRepository.findAll().stream().map((data) -> this.modelMapper.map(data, ImageDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<ImageDto> createDatas(List<VariantDto> dto) {
		
		List<Image> all = new ArrayList<>();
		
		for(int i = 0; i < dto.size();i++) {
			
			VariantDto variantDto = dto.get(i);
			Variant variant  = this.variantRepository.findById(variantDto.getVariantid()).orElseThrow(() -> new ResourceNotFoundException("Varient", "Id", variantDto.getVariantid()));
		    
			List<Image> images = new ArrayList<>();
			
	        List<ImageDto> images2 = variantDto.getImages();

			for (int j = 0; j < images2.size(); j++) {
				
				ImageDto imag = images2.get(j);
				
				 Image image = this.modelMapper.map(imag, Image.class);
				 image.setImageid(imag.getImageid() <0? null : imag.getImageid());
				 
				 image.setVariant(variant);
			    images.add(image);
			
			}
			
			List<Image> addedImage = this.imageRepository.saveAll(images);
			all.addAll(addedImage);
		}
		
		List<ImageDto> collect = all.stream().map(d -> this.modelMapper.map(d, ImageDto.class)).collect(Collectors.toList());
		return collect;
	}

}
