package nl.reproduction.issue2095.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Home Controller
 * 
 */
@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping(method=RequestMethod.GET)
	public String get(){
		return "redirect:/home";
	}
	
}
