package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan
@SpringBootApplication
public class HelloworldApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}
}
