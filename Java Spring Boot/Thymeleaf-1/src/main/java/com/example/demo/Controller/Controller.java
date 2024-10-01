package com.example.demo.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.stereotype.Controller
public class Controller {
	
	@GetMapping("/")
	public String home(Model model) {
		
		model.addAttribute("age",25);
		System.out.println("home handler");
		
		return "home";
	}

	@RequestMapping(value = "/about",method = RequestMethod.GET)
	public String about(Model model) {
		
		System.out.println("about handler");
		model.addAttribute("name","krishna");
		return "about";
	}
	@RequestMapping(value = "/contact",method = RequestMethod.GET)
	public String contact(Model model) {
		System.out.println("contact handler");
		return "contact";
	}
	
}
