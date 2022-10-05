package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {
	
	@GetMapping(value="/")
	public String greetings() {
		
		return "welcome to spring boot with docker image creation by jaya";	
	}
	
	@GetMapping(value="say/{name}")
	public String greeting(@PathVariable("name") String username) {
		
		return "welcome "+username+" to spring boot with docker image creation";	
	}
	
	

}
