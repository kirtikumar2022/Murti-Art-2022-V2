package com.murtiart.size;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murtiart.exceptions.ResourceNotFoundException;

@Service
public class MurtiSizeServiceImpl  implements MurtiSizeService{
	
	@Autowired
	private MurtiSizeRepository murtiSizeRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	
	@Override
	public MurtiSizeDto createData(MurtiSizeDto dto) {
		MurtiSize murtiSize = this.modelMapper.map(dto, MurtiSize.class);
		MurtiSize saveMurtiSize = this.murtiSizeRepository.save(murtiSize);
		return this.modelMapper.map(saveMurtiSize, MurtiSizeDto.class);
	}

	@Override
	public MurtiSizeDto updateData(MurtiSizeDto dto, Integer murtiSizeId) {
		MurtiSize murtiSize = this.murtiSizeRepository.findById(murtiSizeId).orElseThrow(() -> new ResourceNotFoundException("MurtiSize", "id",murtiSizeId));
		murtiSize.setValue(dto.getValue());
		murtiSize.setRemove(dto.getRemove());
		MurtiSize saveMurtiSize = this.murtiSizeRepository.save(murtiSize);
		return modelMapper.map(saveMurtiSize, MurtiSizeDto.class);
	}

	@Override
	public MurtiSizeDto deleteData(Integer murtiSizeId, Integer remove) {
		MurtiSize murtiSize = this.murtiSizeRepository.findById(murtiSizeId).orElseThrow(() -> new ResourceNotFoundException("MurtiSize","id",murtiSizeId));
		murtiSize.setRemove(remove==1);
		MurtiSize saveImage = this.murtiSizeRepository.save(murtiSize);
		return modelMapper.map(saveImage, MurtiSizeDto.class);
	}

	@Override
	public MurtiSizeDto getData(Integer imageId) {
		MurtiSize murtiSize = this.murtiSizeRepository.findById(imageId).orElseThrow(() -> new ResourceNotFoundException("MurtiSize","id",imageId));
		return this.modelMapper.map(murtiSize, MurtiSizeDto.class);
	}

	@Override
	public List<MurtiSizeDto> getDatas() {
		return  this.murtiSizeRepository.findAll().stream().map((data) -> this.modelMapper.map(data, MurtiSizeDto.class)).collect(Collectors.toList());
	}

}

