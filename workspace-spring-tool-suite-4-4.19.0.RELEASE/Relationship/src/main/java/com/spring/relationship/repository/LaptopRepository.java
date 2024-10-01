package com.spring.relationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.relationship.Entity.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop, Integer> {

}
