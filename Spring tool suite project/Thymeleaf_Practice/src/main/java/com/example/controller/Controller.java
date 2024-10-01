package com.example.controller;

import java.util.Date;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
	
	@GetMapping("/")
	public String home(Model model) {
		
		System.out.println("Home handler");
		model.addAttribute("name","krisna");
		
		return "home";
	}
	@GetMapping("about")
	public String about(Model model) {
		System.out.println("about handler");
		model.addAttribute("current_date",new Date().toLocaleString());
		
		List<String> author = List.of("james","bond","john","ganpat");
		model.addAttribute("author_name",author);
		
		List<Integer> num = List.of(1,2,3,4,5,6,7,8);
		
		model.addAttribute("number",num);
		
		model.addAttribute("isActive",true);
		
		model.addAttribute("gender",'M');
		
		return "about";
	}
	
	@GetMapping("/service")
	public String service_fragement(Model model) {
		
		model.addAttribute("name","Ramesh kumar sah");
		model.addAttribute("age",25);
		
		System.out.println("Service handler");
		model.addAttribute("title","This is the title of page");
		model.addAttribute("subtitle","This is the subtitle of page");
		return "service";
	}
	
	@GetMapping("example-iteration")
	public String iteration(Model model) {
		
		System.out.println("Iteration handler");
		List<String> names = List.of("krishna","sarfaraz","balram","ramesh");
		model.addAttribute("names",names);
		return "example_iteration";
	}

}
