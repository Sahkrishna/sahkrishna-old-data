package com.practice.ems.Controller;

import com.practice.ems.dto.EmployeeDto;
import com.practice.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto emp=this.employeeService.createEmployee(employeeDto);

        return new  ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getSingleEmp(@PathVariable("id") int empId){

       EmployeeDto emp= this.employeeService.getEmployeeById(empId);

       return  new ResponseEntity<>(emp,HttpStatus.FOUND);
    }

    @GetMapping("/")
    public ResponseEntity<List<EmployeeDto>> getAllEmp(){

        List<EmployeeDto> employees=this.employeeService.getAllEmp();

        return ResponseEntity.ok(employees);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int empId){

        this.employeeService.deleteEmp(empId);

        return ResponseEntity.ok("Deleted successfully");
    }
    @PutMapping("/{id}/update")
    public ResponseEntity<EmployeeDto> updatedEmployee(@PathVariable("id") int empId,@RequestBody EmployeeDto empDto){

       EmployeeDto employee= this.employeeService.updateEmp(empId,empDto);

       return ResponseEntity.ok(employee);
    }
}
