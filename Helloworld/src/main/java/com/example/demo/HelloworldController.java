package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloworldController {
	@RequestMapping("/home")

	
	public String hello() {
		return "HelloWorld!!";
	
		
	}
	 



}
