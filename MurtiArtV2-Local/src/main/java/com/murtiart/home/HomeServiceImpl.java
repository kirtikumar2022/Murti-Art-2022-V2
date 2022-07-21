package com.murtiart.home;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murtiart.banner.BannerDto;
import com.murtiart.banner.BannerRepository;
import com.murtiart.category.Category;
import com.murtiart.category.CategoryDto;
import com.murtiart.category.CategoryRepository;

@Service
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	private BannerRepository bannerRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
 
	@Override
	public HomeResponse getHomeData() {
		HomeResponse homeResponse = new HomeResponse();
		
		List<CategoryDto> finalCategory = new ArrayList<>();
		this.categoryRepository.findAll().forEach(c -> {
			if (!c.getRemove()) {
				finalCategory.add(this.modelMapper.map(c, CategoryDto.class));
			}
		});
		
		List<BannerDto> finalBanner = new ArrayList<>();
		this.bannerRepository.findAll().forEach(b -> {
			if (!b.getRemove()) {
				finalBanner.add(this.modelMapper.map(b, BannerDto.class));
			}
		});
		
		
		homeResponse.setBanners(finalBanner);
		homeResponse.setCategories(finalCategory);
		return homeResponse;
	}
	
}