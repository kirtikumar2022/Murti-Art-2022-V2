package com.murtiart.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.murtiart.address.AddressRepository;
import com.murtiart.address.Addresss;
import com.murtiart.attribute.Attribute;
import com.murtiart.attribute.AttributeRepository;
import com.murtiart.category.Category;
import com.murtiart.category.CategoryRepository;
import com.murtiart.config.AppConstants;
import com.murtiart.exceptions.ResourceNotFoundException;
import com.murtiart.faviourte.FaviouriteResponse;
import com.murtiart.faviourte.Favourite;
import com.murtiart.faviourte.FavouriteDto;
import com.murtiart.faviourte.FavouriteRepository;
import com.murtiart.images.Image;
import com.murtiart.images.ImageRepository;
import com.murtiart.user.User;
import com.murtiart.user.UserRepository;
import com.murtiart.variant.Variant;
import com.murtiart.variant.VariantDto;
import com.murtiart.variant.VariantRepository;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private FavouriteRepository favouriteRepository;
	
	@Autowired
	private VariantRepository variantRepository;
	
	@Autowired
	private ImageRepository imageRepository;

	@Autowired
	private AttributeRepository attributeRepository;
	
	
	
	
	@Override
	public ProductDto createProduct(ProductDto dto, Integer userId, Integer categoryId, Integer addressId) {

		User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "User id", userId));
		Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category id", categoryId));
		Addresss  address = this.addressRepository.findById(addressId).orElseThrow(()-> new ResourceNotFoundException("Address","Adress Id", addressId));
		
		List<Variant> varientList = new ArrayList<>();
		List<Attribute> attrobuteList = new ArrayList<>();
		List<Image> imagesList = new ArrayList<>();
		
		if (dto!=null) {
			
			// 1. Create Product 
			Product product = this.modelMapper.map(dto, Product.class);
			product.setCategory(category);
			product.setUser(user);
			product.setAddress(address);
			Product saveProduct = this.productRepository.save(product);
			
			// 2. Create All variant of product and attribute and image too
			if(dto.getVariants()!=null) {
			 
			Set<VariantDto> variants = dto.getVariants();
		
			  variants.forEach(data -> {
				  
				  Variant map = this.modelMapper.map(data, Variant.class);
				  map.setProduct(saveProduct);
				
				  // Save Variant
				  Variant  saveVariant = this.variantRepository.save(map);
				  
							  // Attribute
							  if(map.getAttributes()!=null) {
								
								  map.getAttributes().forEach(a -> {
									  
									  Attribute attribute = this.modelMapper.map(a, Attribute.class);
									  attribute.setVariant(saveVariant);
									  
									  // Save Attribute
									  Attribute saveAttribute = this.attributeRepository.save(attribute);
									 
									  // set data
									  attrobuteList.add(saveAttribute);
									 
								  });
			
							  } else{ // Attribute is null
							           }
				  
							  // Images
							  if(map.getImages()!=null) {
								
								  map.getImages().forEach(i-> {
									  
									  Image image = this.modelMapper.map(i, Image.class);
									  image.setVariant(saveVariant);
									  
									  // Save Attribute
									  Image saveImages = this.imageRepository.save(image);
									  
									  // set Data
									  imagesList.add(saveImages);
								  });
			
							  } else{  // Image is null
							            }
			  
					// Set Data
					saveVariant.setAttributes(attrobuteList);
					saveVariant.setImages(imagesList);
					varientList.add(saveVariant);
			  });
			  
			} else {
				// product varient is null
			}
			
			// Set Data
			saveProduct.setVariants(varientList);
			
		} else {
			
			// Product dto is null
		}
		 
		return  this.modelMapper.map(dto, ProductDto.class);
	}

	@Override
	public ProductDto updateProduct(ProductDto dto, Integer productId) {
		Product product = this.productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product", "Product id", productId));
		Addresss address = this.addressRepository.findById(dto.getAddress().getAddressid()).orElseThrow(()-> new ResourceNotFoundException("Address", "Address id", product.getAddress().getAddressid()));
		
		product.setProductName(dto.getProductName());
		product.setProductDesc(dto.getProductDesc());
		product.setAddress(address);
		product.setRemove(dto.getRemove());
		Product updateProduct = this.productRepository.save(product);		
		return this.modelMapper.map(updateProduct, ProductDto.class);
	}

	@Override
	public ProductDto deleteProduct(Integer productId, Integer isRemove) {
		Product product = this.productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product", "Product id", productId));
		product.setRemove(isRemove == 1);
		Product updatePeoduct = this.productRepository.save(product);
		return this.modelMapper.map(updatePeoduct, ProductDto.class);
	}

 
	@Override
	public ProductDto getProductById(Integer productId) {
		Product product = productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product", "Product id", productId));
		return this.modelMapper.map(product, ProductDto.class);
	}

	private List<ProductDto> searchData(String keyword, List<Product> products) {
		List<ProductDto> list = new ArrayList<>();
		products.forEach(data -> {
				if (data.getProductName().toLowerCase().contains(keyword.toLowerCase())) 
					 list.add(this.modelMapper.map(data, ProductDto.class));
		});
		return list;
	}
	
	
	private List<Product> filterByUser(List<Product> products, User user) {
		return products.stream()
				  .filter(p -> p.getUser().getUserid() == user.getUserid())
				  .filter(p -> !p.getRemove())
				  .collect(Collectors.toList());
	}
	
	
	private List<Product> filterByUserAndCategory(List<Product> products, User user, Category category) {
		return products.stream()
				  .filter(p -> p.getUser().getUserid() == user.getUserid())
				  .filter(p -> p.getCategory().getCategoryid() == category.getCategoryid())
				  .filter(p -> !p.getRemove())
				  .collect(Collectors.toList());
	}
	

	private List<Product> filterByCategory(List<Product> products, Category category) {
		return products.stream()
				  .filter(p -> p.getCategory().getCategoryid() == category.getCategoryid())
				  .filter(p -> !p.getRemove())
				  .collect(Collectors.toList());
	}
	
	
	
	private List<ProductDto> filterDto(List<Product> products) {
		return products.stream()
				  .map((p) -> this.modelMapper.map(p, ProductDto.class))
				  .collect(Collectors.toList());
	}

	
	@Override
	public ProductResponse getAllProduct(Integer pageNumber, Integer pageSize, String sortBy, 
//			String sortDirection,
			Integer categoryId, Integer userId, String keyword) {
		
		
				if (pageNumber >= 0) {
					
					Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).ascending());
					Page<Product> page =  this.productRepository.findAll(pageable);
					
					List<Product> products = page.getContent();
					List<ProductDto> list = new ArrayList<>();
					
					
					if (categoryId != -1){

			            if (userId != -1){
			                
			                if (keyword!=null && !keyword.isEmpty()){
			                	
			                	User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User id", userId));
								Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category id", categoryId));
								
								List<Product> filterUserAndCategory = filterByUserAndCategory(products, user, category);
								List<ProductDto> filterDto = searchData(keyword, filterUserAndCategory);
								
								// SUPER WORK
			            		 if (filterDto.size() == 0) {
			            			 
			            			 for (int i = 0; i < pageSize; i++) {
			            				 
			            				 Pageable superPageable = PageRequest.of(pageNumber, pageSize,  Sort.by(sortBy).ascending());
				            			 page =  this.productRepository.findAll(superPageable);
				            			 products = page.getContent();
				            			 
				            			 List<Product> nFilterByCategory = filterByUserAndCategory(products,user, category);
					            		 List<ProductDto> nFilterDto = filterDto(nFilterByCategory);
										
					            		 if (nFilterDto.size()>0) {
					            			list.addAll(nFilterDto);
					            			break;
										}
					            		pageNumber++;
									}
								} else {
									 list.addAll(filterDto);	 
								}
			                	
			                } else {
			                	
			                	User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User id", userId));
								Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category id", categoryId));
								
								List<Product> filterByUserAndCategory = filterByUserAndCategory(products, user, category);
								List<ProductDto> filterDto = filterDto(filterByUserAndCategory);
								
								// SUPER WORK
			            		 if (filterDto.size() == 0) {
			            			 
			            			 for (int i = 0; i < pageSize; i++) {
			            				 
			            				 Pageable superPageable = PageRequest.of(pageNumber, pageSize,  Sort.by(sortBy).ascending());
 				            			 page =  this.productRepository.findAll(superPageable);
 				            			 products = page.getContent();
 				            			 
 				            			 List<Product> nFilterByCategory = filterByUserAndCategory(products,user, category);
 					            		 List<ProductDto> nFilterDto = filterDto(nFilterByCategory);
										
 					            		 if (nFilterDto.size()>0) {
 					            			list.addAll(nFilterDto);
 					            			break;
										}
 					            		pageNumber++;
									}
								} else {
									
									 list.addAll(filterDto);	 
								
								}
			                	
			                }
			                
			            } else {
			                
			            	  if (keyword!=null && !keyword.isEmpty()){
			                 
			            		  Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category id", categoryId));
			            		  List<Product> filterByUserAndCategory = filterByCategory(products, category);
			            		  List<ProductDto> filterDto = searchData(keyword, filterByUserAndCategory);
			            		  
			            		  
			            		// SUPER WORK
				            		 if (filterDto.size() == 0) {
				            			 
				            			 for (int i = 0; i < pageSize; i++) {
				            				 
				            				 Pageable superPageable = PageRequest.of(pageNumber, pageSize,  Sort.by(sortBy).ascending());
					            			 page =  this.productRepository.findAll(superPageable);
					            			 products = page.getContent();
					            			 
					            			 List<Product> nFilterByCategory = filterByCategory(products,category);
						            		 List<ProductDto> nFilterDto = filterDto(nFilterByCategory);
											
						            		 if (nFilterDto.size()>0) {
						            			list.addAll(nFilterDto);
						            			break;
											}
						            		pageNumber++;
										}
									} else {
										
										 list.addAll(filterDto);	 
									
									}
			            		  
			                } else {
			                  
			                	 Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category id", categoryId));
			                	 
			                	 List<Product> filterByCategory = filterByCategory(products, category);
			            		 List<ProductDto> filterDto = filterDto(filterByCategory);
			            		  
			            		 // SUPER WORK
			            		 if (filterDto.size() == 0) {
			            			 
			            			 for (int i = 0; i < pageSize; i++) {
			            				 
			            				 Pageable superPageable = PageRequest.of(pageNumber, pageSize,  Sort.by(sortBy).ascending());
  				            			 page =  this.productRepository.findAll(superPageable);
  				            			 products = page.getContent();
  				            			 
  				            			 List<Product> nFilterByCategory = filterByCategory(products, category);
  					            		 List<ProductDto> nFilterDto = filterDto(nFilterByCategory);
										
  					            		 if (nFilterDto.size()>0) {
  					            			list.addAll(nFilterDto);
  					            			break;
										}
  					            		pageNumber++;
									}
								} else {
									
									 list.addAll(filterDto);	 
								
								}
			                }
			            }

			        } else {

			            if (userId != -1){
			                
			            	  if (keyword!=null && !keyword.isEmpty()){

			            			User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User id", userId));
			            			List<Product> filterbyUser = filterByUser(products, user);
			            			List<ProductDto> filterDto = searchData(keyword,filterbyUser);
								

			            			// SUPER WORK
				            		 if (filterDto.size() == 0) {
				            			 
				            			 for (int i = 0; i < pageSize; i++) {
				            				 
				            				 Pageable superPageable = PageRequest.of(pageNumber, pageSize,  Sort.by(sortBy).ascending());
	  				            			 page =  this.productRepository.findAll(superPageable);
	  				            			 products = page.getContent();
	  				            			 
	  				            			 List<Product> nFilterByCategory = filterByUser(products, user);
	  					            		 List<ProductDto> nFilterDto = filterDto(nFilterByCategory);
											
	  					            		 if (nFilterDto.size()>0) {
	  					            			list.addAll(nFilterDto);
	  					            			break;
											}
	  					            		pageNumber++;
										}
									} else {
										
										 list.addAll(filterDto);	 
									
									}
			            			
			            		  
			                } else {
			                
		            			User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User id", userId));
		            			List<Product> filterbyUser = filterByUser(products, user);
		            			List<ProductDto> filterDto = filterDto(filterbyUser);
							 
		            			
		            			// SUPER WORK
			            		 if (filterDto.size() == 0) {
			            			 
			            			 for (int i = 0; i < pageSize; i++) {
			            				 
			            				 Pageable superPageable = PageRequest.of(pageNumber, pageSize,  Sort.by(sortBy).ascending());
 				            			 page =  this.productRepository.findAll(superPageable);
 				            			 products = page.getContent();
 				            			 
 				            			 List<Product> nFilterByCategory = filterByUser(products, user);
 					            		 List<ProductDto> nFilterDto = filterDto(nFilterByCategory);
										
 					            		 if (nFilterDto.size()>0) {
 					            			list.addAll(nFilterDto);
 					            			break;
										}
 					            		pageNumber++;
									}
								} else {
									
									 list.addAll(filterDto);	 
								
								}
			                	
			                }
			                
			            } else {
			                
			            	  if (keyword!=null && !keyword.isEmpty()){
			                 
			            		  List<ProductDto> filterDto = searchData(keyword,products);
			            		  
			            			// SUPER WORK
				            		 if (filterDto.size() == 0) {
				            			 
				            			 for (int i = 0; i < pageSize; i++) {
				            				 
				            				 Pageable superPageable = PageRequest.of(pageNumber, pageSize,  Sort.by(sortBy).ascending());
	 				            			 page =  this.productRepository.findAll(superPageable);
	 				            			 products = page.getContent();
	 				            			 
	 				            			 List<ProductDto> nFilterDto = searchData(keyword,products);
											
	 					            		 if (nFilterDto.size()>0) {
	 					            			list.addAll(nFilterDto);
	 					            			break;
											}
	 					            		pageNumber++;
										}
									} else {
										
										 list.addAll(filterDto);	 
									
									}
			            		  
			                } else {
			                	
			                	list.addAll(filterDto(products));
			                
			                }
			            }
			        }
					
					
					
//					if (userId != -1) {
//						if (categoryId != -1) {
//							
//							// Search | filter by user, cat
//							if (keyword!=null && !keyword.isEmpty()) {
//								User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User id", userId));
//								Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category id", categoryId));
//								list.addAll(searchData(keyword, filterByUserAndCategory(products, user, category)));
//							}
//							
//							// No search | filter by cat and user
//							else {
//								User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User id", userId));
//								Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category id", categoryId));
//								
//								List<Product> filterByUserAndCategory = filterByUserAndCategory(products, user, category);
//								List<ProductDto> filterDto = filterDto(filterByUserAndCategory);
//								
//								list.addAll(filterDto);
//							}
//						}  
//						// No Category and filter by user
//						else {
//							
//							User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User id", userId));
//							 
//							// Search and filter by user
//							if (keyword!=null && !keyword.isEmpty()) {
//								
//								 list.addAll(searchData(keyword, filterByUser(products, user)));
//							
//							}
//							
//							// No Search and filter by user
//							else {
//								 list.addAll(filterDto(filterByUser(products, user)));
//							  }
//						}
//					} 
//					
//					// No Cat and User
//					else {
//						
//						// Search and No Cat and User  
//						if (keyword!=null && !keyword.isEmpty()) {
//							list.addAll(searchData(keyword, products));
//						} 
//						// No search, user and cat
//						else {
//							list.addAll(filterDto(products));
//						}
//					}
				
					
					ProductResponse productResponse = new ProductResponse();
					productResponse.setContent(list);
					productResponse.setPageNumber(page.getNumber());
					productResponse.setPageSize(page.getSize());
					productResponse.setTotalElement(page.getTotalElements());
					productResponse.setTotalPages(page.getTotalPages());
					productResponse.setLastPage(page.isLast());
					
					return productResponse;
					
					}
					else {
						
						ProductResponse productResponse = new ProductResponse();
						productResponse.setContent(new ArrayList<>());
						productResponse.setPageNumber(pageNumber);
						productResponse.setPageNumber(pageNumber);
						productResponse.setTotalElement(0L);
						productResponse.setTotalPages(0);
						productResponse.setLastPage(true);
						
						return productResponse;
						
					}
			}

}
