package com.murtiart.address;

import java.util.List;

public interface AddressService {
	
	  AddressDto createOrUpdateAddress(AddressDto dto, Integer userId);
		
//	  AddressDto updateAddress(AddressDto dto, Integer addressId, Integer userId);
	
	  AddressDto deleteAddress(AddressDto dto, Integer addressId, Integer remove);
	  
	  AddressDto getAddress(Integer addressId);
	
	  List<AddressDto> getAddresByUser(int userId);
	  
	  Boolean isAddressExist(Long mobile);

}