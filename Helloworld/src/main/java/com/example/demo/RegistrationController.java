 package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
	@Autowired
	CoustmerRepo repo;
	
	@RequestMapping("/")
	public String details()
	{
		return "registration";
	} 
	@RequestMapping("/details")
	public String details(Coustmers coustmers)
	{
		
		repo.save(coustmers);
		return "registration";
		}
		@RequestMapping("/getdetails")
		public String getdetails()
		{
		
			return "viewcoustmer";
	} 
	
	@PostMapping("/getdetails")
    public ModelAndView getdetails(@RequestParam int id)
    {
		ModelAndView mv=new ModelAndView("retrive");
              Coustmers coustmers=repo.findById(id).orElse(null);
              mv.addObject(coustmers);
              return mv;
    }
}