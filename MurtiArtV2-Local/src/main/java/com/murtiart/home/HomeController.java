package com.murtiart.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	@GetMapping("")
	public HomeResponse  getHomeData(){
		return this.homeService.getHomeData();
	}
}
