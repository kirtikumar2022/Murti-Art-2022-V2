package com.murtiart.about;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murtiart.exceptions.ResourceNotFoundException;

@Service
public class AboutUsServiceImpl implements AboutUsService{

	@Autowired
	AboutUsRepository aboutUsRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	
	@Override
	public AboutUsDto createData(AboutUsDto dto) {
		AboutUs aboutUs = this.modelMapper.map(dto, AboutUs.class);
		AboutUs addedImage = this.aboutUsRepository.save(aboutUs);
		return this.modelMapper.map(addedImage, AboutUsDto.class);
	}
	

	@Override
	public AboutUsDto updateData(AboutUsDto dto, Integer aboutusId) {
		AboutUs aboutUs = this.aboutUsRepository.findById(aboutusId).orElseThrow(() -> new ResourceNotFoundException("Aboutus", "id",aboutusId));
		aboutUs.setType(dto.getType());
		aboutUs.setName(dto.getName());
		aboutUs.setDescription(dto.getDescription());
		aboutUs.setEmail(dto.getEmail());
		aboutUs.setPhone(dto.getPhone());
		aboutUs.setGender(dto.getGender());
		aboutUs.setRemove(dto.getRemove());
		aboutUs.setImage(dto.getImage());
		AboutUs saveAboutUs = this.aboutUsRepository.save(aboutUs);
		return modelMapper.map(saveAboutUs, AboutUsDto.class);
	} 
	
	@Override
	public List<AboutUsDto> getDatas() {
		return  this.aboutUsRepository.findAll().stream().map((data) -> this.modelMapper.map(data, AboutUsDto.class)).collect(Collectors.toList());
	}
	

	@Override
	public AboutUsDto deleteData(Integer aboutusId, Integer remove) {
		AboutUs aboutUs = this.aboutUsRepository.findById(aboutusId).orElseThrow(() -> new ResourceNotFoundException("Aboutus","id",aboutusId));
		aboutUs.setRemove(remove==1);
		AboutUs saveAboutUs = this.aboutUsRepository.save(aboutUs);
		return modelMapper.map(saveAboutUs, AboutUsDto.class);
	}


	@Override
	public AboutUsDto getData(Integer aboutusId) {
		AboutUs aboutUs = this.aboutUsRepository.findById(aboutusId).orElseThrow(() -> new ResourceNotFoundException("AboutUs","id",aboutusId));
		return this.modelMapper.map(aboutUs, AboutUsDto.class);
	}

}
