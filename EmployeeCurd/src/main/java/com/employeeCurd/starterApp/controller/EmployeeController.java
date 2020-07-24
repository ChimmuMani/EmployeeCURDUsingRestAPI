package com.employeeCurd.starterApp.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeCurd.starterApp.exception.ResourceNotFoundException;
import com.employeeCurd.starterApp.model.Employee;


@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
//@RestController
public class EmployeeController {
	@Autowired
	private  EmployeeService employeeservice;
	
	@GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return  employeeservice.getAllEmployeesDetails();
    }
	@GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getAllEmployeesbyId(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
        return  employeeservice.getAllEmployeesDetailsId(employeeId);
    }
	@PostMapping("/employees")
    public Employee createEmployee(@Validated @RequestBody Employee employee) {
		System.out.println("test"+employee.getLastName());
        return employeeservice.savedetails(employee);
    }
	@PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
         @Validated @RequestBody Employee employeeDetails)   {
		
		 return employeeservice.updatedemployee(employeeId,employeeDetails);
    }

	@DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
        {
       return employeeservice.deleteEmpId(employeeId);
    }
}
