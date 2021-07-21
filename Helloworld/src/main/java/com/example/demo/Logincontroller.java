package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Logincontroller {
	Logger log=LoggerFactory.getLogger(Logincontroller.class);
@Autowired
CoustmerRepo repo;
@RequestMapping("/login")
public String login() {
	
	return "login";
}

@PostMapping("/login")
public ModelAndView login(@RequestParam int cid,@RequestParam String cpassword,@RequestParam String cusername) {
	
	ModelAndView mv=new ModelAndView();
	Coustmers coustmers=repo.findById(cid).orElse(null);
	if((coustmers.getCpassword().equals(cpassword))&(coustmers.getCusername().equals(cusername))){
		System.out.println("success");
		log.info(cusername+"logged in");
	
	}
	else {
		System.out.println("failure");
		log.info(cusername+"failed to login");
		log.warn(cusername+"u have only 3 attempts");
	}
	return mv;
}
}

