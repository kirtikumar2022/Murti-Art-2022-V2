package com.murtiart.user;

import java.util.List;

import com.murtiart.roles.RoleDto;

public interface UserService {
	
	UserDto registerUser(UserDto user, Integer roleId);
	
//	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto user, Integer userId);
	
	UserDto getUserById(Integer userId);
	
	UserDto getUserByEmail(String email);
	
	Boolean isUserExist(String email);
	
	List<RoleDto> getUserByRole(Integer userId);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer userId, Integer remove);
	
	ShopKeeperResponse getShopKeepers(Integer pageNumber , Integer pageSize, String sortBy, String sortDirection,Integer roleId);
}
