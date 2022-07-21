package com.murtiart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/")
	public String createVariant() {
		return "Hello & Welcome to CloudKatha !!!";
	}
}
