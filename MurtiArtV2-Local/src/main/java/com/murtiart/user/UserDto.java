package com.murtiart.user;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.murtiart.address.AddressDto;
import com.murtiart.address.Addresss;
import com.murtiart.roles.RoleDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private Integer userid;
	
	@Email(message = "Email id is not valid")
	@Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}")
	private String email;
	
	@NotNull
	@Size(min = 4, message = "Username name should be minium 4 charector long")
	private String name;

	@NotEmpty
	private String fireBaseId;
	
	private Long subscription;
	
	private Long mobile;
	
	@NotEmpty
	private String image;
	
	@NotEmpty
	private String gender;
	
	@NotEmpty
	private String deviceToken;
	
	private Integer rating;
	
	private Boolean isActive; 
	
	private Integer request; // This is for shopkeeper request if 0 means accepted 1 means not accepted by Admin  
	
	private List<AddressDto> address = new ArrayList<>();
	
	private List<RoleDto> roles = new ArrayList<>();
	
//	private List<BannerDto> banners = new ArrayList<>();


}