package com.java.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.jpa.Entity.Customer;
import com.java.jpa.dto.OrderRequest;
import com.java.jpa.repository.CustomerRepo;
import com.java.jpa.repository.ProductRep;

@RestController
public class OrderController {
	
	@Autowired
	private ProductRep productRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	
	@PostMapping("/placeOrder")
	public Customer placeOrder(@RequestBody OrderRequest request) {
		return customerRepo.save(request.getCustomer());
	}
	
	@GetMapping("/findAllOrder")
	public List<Customer> findAllOrder(){
		
		return customerRepo.findAll();
	}

}
