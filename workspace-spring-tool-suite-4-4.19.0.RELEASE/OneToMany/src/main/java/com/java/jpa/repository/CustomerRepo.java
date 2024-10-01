package com.java.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.jpa.Entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
