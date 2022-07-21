package com.murtiart.address;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.murtiart.user.User;


public interface AddressRepository  extends JpaRepository<Addresss, Integer>{

	Optional<Addresss> findByMobile(Long mobile);
	
//	Optional<Addresss> findByUsers(User  user);
	
	List<Addresss> findByUsers(User  user);
}
