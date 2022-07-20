package com.murtiart.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.murtiart.utils.GenericApiRespons;
import com.murtiart.utils.JsonKeysManageGlobally;

@RestController
@RequestMapping("/api/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/user/{userId}")
	public GenericApiRespons<AddressDto> createOrUpdateUserAddresst(@RequestBody AddressDto dto, @PathVariable Integer userId){
		AddressDto data = this.addressService.createOrUpdateAddress(dto,userId);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,dto.getAddressid() == null ? StringConstants.CREATED : StringConstants.UPDATED, JsonKeysManageGlobally.OK);
	}
	
	@GetMapping("/{userId}")
	public GenericApiRespons<List<AddressDto>> getUserAddress(@PathVariable Integer userId){
		List<AddressDto> list = this.addressService.getAddresByUser(userId);
		return JsonKeysManageGlobally.standaredResponseBuilder(list,StringConstants.FOUND, JsonKeysManageGlobally.OK);
	}
}
