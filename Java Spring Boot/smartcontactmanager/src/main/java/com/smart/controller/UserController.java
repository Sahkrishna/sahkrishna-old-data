package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.dao.UserRepository;
import com.smart.entities.User;
import com.smart.message.Message;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller

public class UserController {
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/home")
	public String home(Model model) {
		
		model.addAttribute("title","Home, Smart contact manager");
		
		return "home";
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("title","About, Smart contact manager");
		
		return "about";
	}
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title","Register, Smart contact manager");
		model.addAttribute("user",new User());
		
		return "signup";
	}
	@PostMapping("/do_register")
	public String doRegister(@Valid @ModelAttribute("user") User user,BindingResult result,@RequestParam(value = "agreement",defaultValue = "false") boolean agreement,Model model,HttpSession session) {
		
		try {
			
			if(!agreement) {
				System.out.println("You haven't agree terms and condtion");
				throw new Exception("You have not agree terms and condition");
			}
			if(result.hasErrors()) {
				System.out.println(result);
				model.addAttribute("user",user);
				return "signup";
				
			}
			user.setEnabled(true);
			user.setImageUrl("default_image");
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setRole("ROLE_USER");
			
			
			
			System.out.println(agreement);
			System.out.println(user);
			System.out.println(user.getEmail());
			
			model.addAttribute("user",new User());
			session.setAttribute("message", new Message("Register successfully", "alert-success"));
			this.userRepository.save(user);
			return "signup";
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			model.addAttribute("user",user);
			session.setAttribute("message",new Message("something went wrong !!"+e.getMessage(), "alert-danger"));
			
			return "signup";
		}
	}

}
