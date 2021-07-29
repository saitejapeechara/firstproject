package com.example.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@ComponentScan
@SpringBootApplication(scanBasePackages ="com.ibs.demo2.controller")
@EnableJpaRepositories(basePackages = "com.ibs.demo2.repo")
@EntityScan(basePackages = "com.ibs.demo2.model")
public class HelloworldApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}
}
