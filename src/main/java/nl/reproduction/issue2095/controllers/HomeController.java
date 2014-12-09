package nl.reproduction.issue2095.controllers;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String get(Model model){
		model.addAttribute("now", new DateTime());
		return "redirect:/home";
	}
	
}
