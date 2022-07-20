package com.murtiart.banner;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murtiart.exceptions.ResourceNotFoundException;

@Service
public class BannerServiceImpl  implements BannerService{

	
	@Autowired
	private BannerRepository bannerRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public BannerDto createData(BannerDto dto) {
		Banner banner = this.modelMapper.map(dto, Banner.class);
		Banner addedBanner  = this.bannerRepository.save(banner);
		return this.modelMapper.map(addedBanner, BannerDto.class);
	}

	@Override
	public BannerDto updateData(BannerDto dto, Integer bannerId) {
		Banner banner = this.bannerRepository.findById(bannerId).orElseThrow(() -> new ResourceNotFoundException("Banner", "id",bannerId));
		 
		banner.setBannerUrl(dto.getBannerUrl());
		banner.setRemove(dto.getRemove());
		banner.setImage(dto.getImage());
		 
		Banner saveBanner = this.bannerRepository.save(banner);
		
		return modelMapper.map(saveBanner, BannerDto.class);
	}

	@Override
	public BannerDto deleteData(Integer bannerId, Integer remove) {
		Banner banner = this.bannerRepository.findById(bannerId).orElseThrow(() -> new ResourceNotFoundException("Banner","id",bannerId));
		banner.setRemove(remove==1);
		Banner updatedBanner = this.bannerRepository.save(banner);
		return this.modelMapper.map(updatedBanner, BannerDto.class);
	}

	@Override
	public BannerDto getData(Integer bannerId) {
		Banner banner = this.bannerRepository.findById(bannerId).orElseThrow(() -> new ResourceNotFoundException("Banner","id",bannerId));
		return this.modelMapper.map(banner, BannerDto.class);
	}

	@Override
	public List<BannerDto> getDatas() {
		return  this.bannerRepository.findAll().stream().map((data) -> this.modelMapper.map(data, BannerDto.class)).collect(Collectors.toList());
	}

}
