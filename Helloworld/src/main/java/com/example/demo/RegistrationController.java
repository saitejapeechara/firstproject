package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping("/details")
	public String details(Coustmers coustmers) {
		try {
			int passwordLength = coustmers.getCpassword().length();
			int ageLimit = coustmers.getCage();
			if (passwordLength < 5) {
				log.error("criteria is not matched");
				throw new PasswordException("password doesnot match criteria");

			}

			if (ageLimit < 18) {
				log.error("age is below the limit");
				throw new AgeException("you are below tha age criteria");
			}

			repo.save(coustmers);
		} catch (PasswordException e) {
			System.out.println("error" + e.getMessage());
		} catch (AgeException e) {
			System.out.println("error" + e.getMessage());
		}
		return "registration";
	}

	@RequestMapping("/getdetails")
	public String getdetails() {

		return "viewcoustmer";
	}

	@PostMapping("/getdetails")
	public ModelAndView getdetails(@RequestParam int cid) {
		ModelAndView mv = new ModelAndView("retrive");
		Coustmers coustmers = repo.findById(cid).orElse(null);
		mv.addObject(coustmers);
		return mv;
	}
}