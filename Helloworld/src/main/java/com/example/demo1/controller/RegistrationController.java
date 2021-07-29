package com.example.demo1.controller;

import java.util.List;
import java.util.Optional;


import com.example.demo1.repo.CoustmerRepo;
import com.example.demo1.model.Coustmers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.exception.AgeException;
import com.example.exception.PasswordException;

@Controller
public class RegistrationController {
	Logger log = LoggerFactory.getLogger(RegistrationController.class);
	@Autowired
    CoustmerRepo repo;
	@RequestMapping("/")
	public String details() {
		return "registration";
	}

	//@RequestMapping("/details")
	@RequestMapping(value="/details",produces={"application/*","text/html"},consumes={"application/*"})
	@ResponseBody
	public String details(@RequestBody Coustmers coustmers ) throws PasswordException  {
		try {
			int passwordLength = coustmers.getCpassword().length();
			
			if (passwordLength < 5) {
				log.error("criteria is not matched");
				throw new PasswordException("password doesnot match criteria");

			}
			int ageLimit = coustmers.getCage();
			if (ageLimit < 18) {
				log.error("age is below the limit,"+coustmers.getCage());
				throw new AgeException("you are below tha age criteria");
			}

			repo.save(coustmers);
		}
		
//		catch (PasswordException e) {
//			System.out.println("error" + e.getMessage());
//		}
	catch (AgeException e) {
			System.out.println("error" + e.getMessage());
	}
		
		return "registration";
	}

	@RequestMapping("/getdetails")
	public String getdetails() {

		return "viewcoustmer";
	}

//	@PostMapping("/getdetails")
//	public ModelAndView getdetails(@RequestParam int cid) {
//		ModelAndView mv = new ModelAndView("retrive");
//		Coustmers coustmers = repo.findById(cid).orElse(null);
//		mv.addObject(coustmers);
//		return mv;
//	}
	@PostMapping("/getdetails")
	public ModelAndView getdetails(@RequestParam int cid) {
		Coustmers coustmers;
		ModelAndView mv = new ModelAndView("retrive");
		List<Coustmers> CoustmerList = (List<Coustmers>) repo.findAll();
		
		//mv.addObject(coustmers);
		//coustmers.forEach(details->System.out.println(details));
		
		Optional<Coustmers> matchingCoustmer=CoustmerList.stream().filter(p->p.getCid()==(cid)).findFirst();
		if(matchingCoustmer.isPresent()) {
			coustmers= matchingCoustmer.get();
			log.info("person is found"+ coustmers.getCusername());
			mv.addObject(coustmers);
		}else
		{
			coustmers=matchingCoustmer.orElse(null);
			log.info("serached uname is not found",cid);
			mv.setViewName("viewcoustmer");
		}
		return mv;
	}
}