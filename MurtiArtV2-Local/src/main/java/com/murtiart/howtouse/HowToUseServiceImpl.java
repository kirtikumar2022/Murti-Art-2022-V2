package com.murtiart.howtouse;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murtiart.exceptions.ResourceNotFoundException;

@Service
public class HowToUseServiceImpl implements HowToUseService{

	@Autowired
	HowToUseRepository howToUseRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	
	@Override
	public HowToUseDto createData(HowToUseDto dto) {
		HowToUse howToUse = this.modelMapper.map(dto, HowToUse.class);
		HowToUse addedHowToUse = this.howToUseRepository.save(howToUse);
		return this.modelMapper.map(addedHowToUse, HowToUseDto.class);
	}
	

	@Override
	public HowToUseDto updateData(HowToUseDto dto, Integer howToUseId) {
		HowToUse howToUse = this.howToUseRepository.findById(howToUseId).orElseThrow(() -> new ResourceNotFoundException("HowToUse", "id",howToUseId));
		howToUse.setType(dto.getType());
		 
		howToUse.setLink(dto.getLink());
		howToUse.setTitle(dto.getTitle());
		howToUse.setDescription(dto.getDescription());
		howToUse.setThumbnail(dto.getThumbnail());
		howToUse.setRemove(dto.getRemove());
		
		HowToUse saveAboutUs = this.howToUseRepository.save(howToUse);
		return modelMapper.map(saveAboutUs, HowToUseDto.class);
	} 
	
	@Override
	public List<HowToUseDto> getDatas() {
		return  this.howToUseRepository.findAll().stream().map((data) -> this.modelMapper.map(data, HowToUseDto.class)).collect(Collectors.toList());
	}
	

	@Override
	public HowToUseDto deleteData(Integer howToUseId, Integer remove) {
		HowToUse howToUse = this.howToUseRepository.findById(howToUseId).orElseThrow(() -> new ResourceNotFoundException("HowToUse","id",howToUseId));
		howToUse.setRemove(remove==1);
		HowToUse saveAboutUs = this.howToUseRepository.save(howToUse);
		return modelMapper.map(saveAboutUs, HowToUseDto.class);
	}


	@Override
	public HowToUseDto getData(Integer howToUseId) {
		HowToUse howToUse = this.howToUseRepository.findById(howToUseId).orElseThrow(() -> new ResourceNotFoundException("howToUse","id",howToUseId));
		return this.modelMapper.map(howToUse, HowToUseDto.class);
	}

}
