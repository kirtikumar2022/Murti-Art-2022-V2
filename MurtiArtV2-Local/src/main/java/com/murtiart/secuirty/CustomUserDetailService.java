package com.murtiart.secuirty;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.murtiart.exceptions.ResourceNotFoundException;
import com.murtiart.user.User;
import com.murtiart.user.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String data) throws UsernameNotFoundException {
		   // Loading user from database by username 
			User user = this.userRepository.findByEmail(data).orElseThrow(() -> new ResourceNotFoundException("User email id not founcd","omg", 0));
			return user;
	}

}
