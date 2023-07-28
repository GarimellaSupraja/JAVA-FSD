package com.Cloud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("/")
	public String hello() {
	 
		return "Welcome to amazon ec2 online app. "+"Now deploy Springboot to AWS";

	}
}