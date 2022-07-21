package com.murtiart.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.murtiart.roles.Roles;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	Optional<User> findByEmail(String email);
	
	Optional<User> findByFireBaseId(String firebaseId);
	
}
