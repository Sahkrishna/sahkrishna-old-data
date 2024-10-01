package com.practice.ems.repository;

import com.practice.ems.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employee,Integer> {
}
