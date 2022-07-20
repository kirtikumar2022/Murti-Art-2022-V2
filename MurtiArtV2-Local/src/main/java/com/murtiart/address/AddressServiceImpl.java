package com.murtiart.address;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murtiart.exceptions.ResourceNotFoundException;
import com.murtiart.user.User;
import com.murtiart.user.UserRepository;

@Service
public class AddressServiceImpl  implements AddressService{
	
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public AddressDto createOrUpdateAddress(AddressDto dto, Integer userId) {
		Addresss address =  this.modelMapper.map(dto, Addresss.class); 
		User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));
		
		if (dto.getAddressid() == null || dto.getAddressid() == -1) {
			address.setUsers(user);
		} else {
			address.setContactPerson(dto.getContactPerson());
			address.setMobile(dto.getMobile());
			address.setPincode(dto.getPincode());
			address.setContactPerson(dto.getContactPerson());
			address.setAddressType(dto.getAddressType());
			address.setAddress(dto.getAddress());
			address.setShopImage(dto.getShopImage());
			address.setShopName(dto.getShopName());
			address.setRemove(dto.getRemove());
			address.setMakeAsDefault(dto.getMakeAsDefault());
			address.setUsers(user);
		}
		
		Addresss updatedAddress = this.addressRepository.save(address);
		
		if (updatedAddress.getMakeAsDefault()) {
			List<Addresss> findByUsers = this.addressRepository.findByUsers(user);
			
			for (int i = 0; i < findByUsers.size(); i++) {
				
				Addresss	data  = findByUsers.get(i);
				
				if (updatedAddress.getAddressid() != data.getAddressid()) {
					data.setMakeAsDefault(false);
					findByUsers.set(i, data);
				}
				
			}
			this.addressRepository.saveAll(findByUsers);
		}
		return this.modelMapper.map(updatedAddress, AddressDto.class);
	}


	@Override
	public AddressDto getAddress(Integer addressId) {
	Addresss addresss = this.addressRepository.findById(addressId).orElseThrow(() -> new ResourceNotFoundException("Address", "Address Id", addressId));
	return this.modelMapper.map(addresss, AddressDto.class);
	}

	@Override
	public List<AddressDto> getAddresByUser(int userId) {
		User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));
		 List<Addresss> findByUsers = this.addressRepository.findByUsers(user);
		return   findByUsers.stream().map((address) -> this.modelMapper.map(address, AddressDto.class)).collect(Collectors.toList());
	}

	@Override
	public AddressDto deleteAddress(AddressDto dto, Integer addressId,  Integer remove) {
		Addresss addresss = this.addressRepository.findById(addressId).orElseThrow(() -> new ResourceNotFoundException("Address","Address Id",addressId));
		addresss.setRemove(remove==1);
		Addresss updatedAddress = this.addressRepository.save(addresss);
		return modelMapper.map(updatedAddress, AddressDto.class);
	}

	@Override
	public Boolean isAddressExist(Long mobile) {
		return this.addressRepository.findByMobile(mobile).isPresent();
	}

}
