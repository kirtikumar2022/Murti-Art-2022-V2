package com.murtiart.user;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.murtiart.config.AppConstants;
import com.murtiart.utils.ApiResponse;
import com.murtiart.utils.GenericApiRespons;
import com.murtiart.utils.JsonKeysManageGlobally;

@RestController
@RequestMapping("api/users/")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	// shopkeeper?pageNumber=1&pageSize
	@GetMapping("/shopkeeper")
	public GenericApiRespons<ShopKeeperResponse> getShopkeepers(
			@RequestParam(value ="pageNumber", defaultValue =  AppConstants.PAGE_NUMBER, required = false) Integer pageNumber, 
			@RequestParam(value ="pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value ="sortBy", defaultValue =AppConstants.SHOPKEEPER_SORT_BY, required = false) String sortBy,
			@RequestParam(value ="sortDirection", defaultValue = AppConstants.SORT_DIR, required = false) String sortDirection,
			@RequestParam(value ="roleId", defaultValue = AppConstants.SHOPKEEPER_DEFAULT_USER, required = true) Integer roleId) {
		ShopKeeperResponse response = this.userService.getShopKeepers(pageNumber,pageSize,sortBy,sortDirection,roleId);
		return   JsonKeysManageGlobally.standaredResponseBuilder(response,StringConstants.FOUND,true);
	}
	
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto dto, @PathVariable  Integer userId){
		UserDto updatedUser = userService.updateUser(dto, userId);
		return ResponseEntity.ok(updatedUser);
	}
	
//	@PreAuthorize("hasRole('ADMIN')") // Its help limitation of user i.e only admin can Deactive user other can not
	@DeleteMapping("/{id}/remove/option")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id, @PathVariable Integer option){
		userService.deleteUser(id,option);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted",true),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable("id") Integer id){
		return ResponseEntity.ok(userService.getUserById(id));
	}
	
	@GetMapping("")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
}
