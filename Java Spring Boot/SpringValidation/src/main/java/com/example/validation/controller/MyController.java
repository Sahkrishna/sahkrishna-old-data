package com.example.validation.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.validation.entities.LoginData;

@Controller
public class MyController {

	@GetMapping("/login")
	public String loginForm(Model model) {

		System.out.println("Login form handler");
		model.addAttribute("loginData",new LoginData());
		return "login";
	}

	@PostMapping("/process")
	public String submittedForm(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult result) {

		if(result.hasErrors()) {
		
			System.out.println(result);
			return "login";
		}
		
		System.out.println(loginData);
		return "success";
	}
}
