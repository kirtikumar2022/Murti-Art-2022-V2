package com.murtiart.address;



import com.murtiart.user.UserDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddressDto {
	
	private Integer addressid;
	private String contactPerson;
	private Long mobile;
	private Integer pincode;
	private String addressType;
	private String address;
	private String shopImage;
	private String shopName;
	private Boolean remove;
	private Boolean makeAsDefault;
	private UserDto user;

}
