package com.example.demo.Controller;

import java.util.Date;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.stereotype.Controller
public class Controller {
	
	@RequestMapping(value = "/about",method =RequestMethod.GET)
	public String about(Model model) {
		
		System.out.println("about handler");
		model.addAttribute("name","Ramesh");
		model.addAttribute("current_date",new Date().toLocaleString());
		return "about";
	}
	 

}
