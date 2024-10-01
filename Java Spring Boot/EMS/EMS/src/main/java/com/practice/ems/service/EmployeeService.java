package com.practice.ems.service;

import com.practice.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    //saving the employee into the table
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    //getting the employee by id
    EmployeeDto getEmployeeById(int empId);

    //getting all the employee from the employee table
    List<EmployeeDto> getAllEmp();

    //deleting the employee
    void deleteEmp(int id);

    //updating the employee
    EmployeeDto updateEmp(int empId,EmployeeDto employeeDto);


}
