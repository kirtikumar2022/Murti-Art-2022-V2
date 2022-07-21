package com.murtiart.faviourte;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.murtiart.config.AppConstants;
import com.murtiart.exceptions.ResourceNotFoundException;
import com.murtiart.product.Product;
import com.murtiart.product.ProductDto;
import com.murtiart.product.ProductRepository;
import com.murtiart.product.ProductResponse;
import com.murtiart.user.User;
import com.murtiart.user.UserRepository;

@Service
public class FaviourteServiceImpl implements FavouriteService {

	
	@Autowired
	private FavouriteRepository faviouriteRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	

	@Override
	public FavouriteDto createFavourite(Integer userId, Integer productId) {
		User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "User id", userId));
		Product product = this.productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "Product id", productId));
		
		Optional<List<Favourite>> userFavourites = this.faviouriteRepository.findByUserid(user.getUserid());
		
		Favourite found = null;
		  
		  if (userFavourites.isPresent()) {
			  for (int i = 0; i < userFavourites.get().size(); i++) {
				  Favourite favourite = userFavourites.get().get(i);
				   if(favourite.getProductid() == product.getProductid()) {
					   found = favourite;
					   break;
				  }
			}
			  
			  if (found!=null) {
//				  	 Boolean is = !found.getAdded();
//				     found.setAdded(is);
//					 Favourite updateFavourite = this.faviouriteRepository.save(found);
				  	 found.setAdded(false);
				  	 this.faviouriteRepository.delete(found);
					 return this.modelMapper.map(found, FavouriteDto.class);
			  
			  } else {
				    
				   
				   FavouriteDto dto = new FavouriteDto();
				   
				   dto.setUserid(user.getUserid());
				   dto.setProductid(product.getProductid());
				   dto.setAdded(true);
				  
				   Favourite updateFavourite = this.faviouriteRepository.save(this.modelMapper.map(dto, Favourite.class));
				   return this.modelMapper.map(updateFavourite, FavouriteDto.class);
				
			}
		  } 
		  
		  // user not found in fav list i.e no fav product in fav tables so directly add
		  else {
			  
			   FavouriteDto dto = new FavouriteDto();
			   dto.setUserid(user.getUserid());
			   dto.setProductid(product.getProductid());
			   dto.setAdded(true);
				
			   Favourite updateFavourite = this.faviouriteRepository.save(this.modelMapper.map(dto, Favourite.class));
			   return this.modelMapper.map(updateFavourite, FavouriteDto.class);
		  }
	}

	 
	
	@Override
	public FavouriteDto getFavouriteById(Integer productId, Integer userId) {
//		Favourite favourite = this.faviouriteRepository.findById(favouriteId).orElseThrow(()-> new ResourceNotFoundException("Faviourte", "Faviourte id", favouriteId));
		
		User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "User id", userId));
		Optional<List<Favourite>> userFavourites = this.faviouriteRepository.findByUserid(user.getUserid());
		Favourite found = null;
		if (userFavourites.isPresent()) {
			
			for (int i = 0; i < userFavourites.get().size(); i++) {
				Favourite favourite = userFavourites.get().get(i);
				if (favourite.getProductid() == productId) {
					found = favourite;
					break;
				}
			}
			
			if (found == null) {
				FavouriteDto dto = new FavouriteDto();
				dto.setFavouriteid(0);
				dto.setProductid(0);
				dto.setUserid(0);
				dto.setAdded(false);
				return this.modelMapper.map(dto, FavouriteDto.class);
			} else {
				return this.modelMapper.map(found, FavouriteDto.class);
			}
			
			
		} else {
			
			FavouriteDto dto = new FavouriteDto();
			dto.setFavouriteid(0);
			dto.setProductid(0);
			dto.setUserid(0);
			dto.setAdded(false);
			return this.modelMapper.map(dto, FavouriteDto.class);
		}
	}

	@Override
	public ProductResponse getProductByUser(Integer pageNumber, Integer pageSize, String sortBy,
			  Integer userId) {

		User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User id", userId));
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).ascending());
		
		Page<Favourite> page =  this.faviouriteRepository.findAll(pageable);
		List<Favourite> favs = page.getContent();
		
		List<ProductDto> sortedList = new ArrayList<>();
		
		favs.forEach(data -> {
			if (data.getUserid() == user.getUserid()) {
				Product product = this.productRepository.findById(data.getProductid()).orElseThrow(()-> new ResourceNotFoundException("Product", "Product id", data.getProductid()));
				ProductDto dto = this.modelMapper.map(product, ProductDto.class);
				dto.setFavourite(this.modelMapper.map(data, FavouriteDto.class));
				sortedList.add(dto);
			}
		});
		
		ProductResponse productResponse = new ProductResponse();
		productResponse.setContent(sortedList);
		productResponse.setPageNumber(page.getNumber());
		productResponse.setPageNumber(page.getSize());
		productResponse.setTotalElement(page.getTotalElements());
		productResponse.setTotalPages(page.getTotalPages());
		productResponse.setLastPage(page.isLast());
		
		return productResponse;
	}
}
