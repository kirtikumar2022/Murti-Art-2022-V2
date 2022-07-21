package com.murtiart.faviourte;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.murtiart.user.User;

public interface FavouriteRepository  extends JpaRepository<Favourite, Integer>{
	
//	List<Favourite> findByUser(User user);
	
    Optional<List<Favourite>> findByUserid(Integer userid);
    
 

}
