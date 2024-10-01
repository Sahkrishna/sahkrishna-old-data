package com.practice.ems.impl;

import com.practice.ems.Entity.Employee;
import com.practice.ems.dto.EmployeeDto;
import com.practice.ems.exception.ResourceNotFoundException;
import com.practice.ems.mapper.MapperEmployee;
import com.practice.ems.repository.EmployeRepository;
import com.practice.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee emp=MapperEmployee.mapToEmployee(employeeDto);

        Employee employee=this.employeRepository.save(emp);

        return MapperEmployee.mapToDto(employee);
    }

    @Override
    public EmployeeDto getEmployeeById(int empId) {

        Employee employee=this.employeRepository.findById(empId).orElseThrow(()->new ResourceNotFoundException("Employee","employeeId",empId));
        return MapperEmployee.mapToDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmp() {
        List<Employee> employees=this.employeRepository.findAll();
        return employees.stream().map(MapperEmployee::mapToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteEmp(int id) {

        Employee emp1=this.employeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","Id",id));

        this.employeRepository.deleteById(id);

    }

    @Override
    public EmployeeDto updateEmp(int empId, EmployeeDto employeeDto) {
        Employee emp1=this.employeRepository.findById(empId).orElseThrow(()->new ResourceNotFoundException("Employee","Id",empId));

        emp1.setEmail(employeeDto.getEmail());
        emp1.setFirstName(employeeDto.getFirstName());
        emp1.setLastName(employeeDto.getLastName());

        Employee updateEmp=this.employeRepository.save(emp1);
        return MapperEmployee.mapToDto(updateEmp);
    }
}
