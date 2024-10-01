package com.practice.ems.mapper;

import com.practice.ems.Entity.Employee;
import com.practice.ems.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class MapperEmployee {

    public static Employee mapToEmployee(EmployeeDto employeeDto){

        return new Employee(employeeDto.getId(),employeeDto.getFirstName(),employeeDto.getLastName(),employeeDto.getEmail());
    }
    public static EmployeeDto mapToDto(Employee employee){

        return new EmployeeDto(employee.getId(),employee.getFirstName(),employee.getLastName(),employee.getEmail());
    }
}
