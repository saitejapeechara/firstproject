package com.example.demo1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloworldController {
	@RequestMapping("/home")
	public String hello() {
		return "HelloWorld!!";	
	}
}
