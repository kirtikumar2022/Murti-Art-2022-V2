package com.murtiart.user;

 
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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.murtiart.roles.RoleDto;
import com.murtiart.roles.RoleRepository;
import com.murtiart.roles.Roles;
import com.murtiart.address.AddressDto;
import com.murtiart.address.AddressRepository;
import com.murtiart.address.Addresss;
import com.murtiart.config.AppConstants;
import com.murtiart.exceptions.ResourceNotFoundException;

@Service
public class UserServiceImple implements UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Autowired
	private RoleRepository roleRepository;
	

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public UserDto updateUser(UserDto dto, Integer userId) {
		
		User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
	
		
		// Subscription, email id not update
		user.setName(dto.getName());
		user.setImage(dto.getImage());
		user.setGender(dto.getGender());
		user.setMobile(dto.getMobile());
		
		if (dto.getFireBaseId()!=null && !dto.getFireBaseId().isEmpty()) {
			user.setFireBaseId(dto.getFireBaseId());
		}
		
		if (dto.getDeviceToken()!=null && !dto.getDeviceToken().isEmpty()) {
			user.setDeviceToken(dto.getDeviceToken());
		}
		
		if (dto.getFireBaseId()!=null && !dto.getFireBaseId().isEmpty()) {
			user.setFireBaseId(dto.getFireBaseId());
		}
		
		if (dto.getRequest()!=null) {
			user.setRequest(dto.getRequest()); 
		}
		
		if (dto.getIsActive()!=null) {
			user.setIsActive(dto.getIsActive());
		}
		
		if (dto.getRating()!=null) {
			user.setRating(dto.getRating());
		}

		User updatedUser = this.userRepository.save(user);
		
		return this.userToDto(updatedUser);
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepository.findAll();
		return users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
	}

	@Override
	public void deleteUser(Integer userId, Integer remove) {
		User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		user.setIsActive(remove==1);
		this.userRepository.save(user);
	}
	
	
	@Override
	public UserDto getUserByEmail(String email) {
		User user = this.userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User", "email Id" , 0));
		return this.modelMapper.map(user, UserDto.class);
	}
	
	private User dtoToUser(UserDto dto) {
		return this.modelMapper.map(dto,User.class);
	}
	
	
	private UserDto userToDto(User user) {
		return  this.modelMapper.map(user,UserDto.class);
	}

	
	// This is for register for customer or Shopkeeper
	@Override
	public UserDto registerUser(UserDto dto, Integer roleId) {
	
		User user =  this.modelMapper.map(dto, User.class);
		user.setFireBaseId(dto.getFireBaseId());

		// Fetch all roles from db 
		Roles role = this.roleRepository.findById(roleId).get();
		user.getRoles().add(role);
		
		
		User registerUser = this.userRepository.save(user);
		return this.modelMapper.map(registerUser, UserDto.class);
	}

	@Override
	public ShopKeeperResponse getShopKeepers(Integer pageNumber, Integer pageSize, String sortBy, String sortDirection,Integer roleId) {
       
		if (pageNumber >= 0) {
			
				Pageable pageable = PageRequest.of(pageNumber, pageSize, sortDirection.equals(AppConstants.SORT_DIR) ? Sort.by(sortBy).ascending() :Sort.by(sortBy).descending() );
				
				Page<User> page =  this.userRepository.findAll(pageable);
				List<User> users = page.getContent();
				List<UserDto> productDto = new ArrayList<>();
				users.forEach((u) -> {
					for (Roles role : u.getRoles()) {
						if (role.getRoleid() == roleId) {
							productDto.add(this.modelMapper.map(u, UserDto.class));
							break;
						}
					}
				});
				ShopKeeperResponse productResponse = new ShopKeeperResponse();
				productResponse.setContent(productDto);
				productResponse.setPageNumber(page.getNumber());
				productResponse.setPageNumber(page.getSize());
				productResponse.setTotalElement(page.getTotalElements());
				productResponse.setTotalPages(page.getTotalPages());
				productResponse.setLastPage(page.isLast());
		
				return productResponse;
		} else {
			
			ShopKeeperResponse productResponse = new ShopKeeperResponse();
			productResponse.setContent(new ArrayList<>());
			productResponse.setPageNumber(pageNumber);
			productResponse.setPageNumber(pageNumber);
			productResponse.setTotalElement(0L);
			productResponse.setTotalPages(0);
			productResponse.setLastPage(true);
	
			return productResponse;
		}
	}

	@Override
	public List<RoleDto> getUserByRole(Integer userId) {
		User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		List<RoleDto> roleDto = user.getRoles().stream().map((r) -> this.modelMapper.map(r, RoleDto.class)).collect(Collectors.toList());
		return roleDto;
	}

	@Override
	public Boolean isUserExist(String email) {
		return this.userRepository.findByEmail(email).isPresent();
	}

}
