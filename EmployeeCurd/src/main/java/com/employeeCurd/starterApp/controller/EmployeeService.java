package com.employeeCurd.starterApp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employeeCurd.starterApp.exception.ResourceNotFoundException;
import com.employeeCurd.starterApp.model.Employee;
import com.employeeCurd.starterApp.repository.EmployeeRepositary;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepositary employeeRepository;

	
	        



	public List<Employee> getAllEmployeesDetails() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();	   
	
	}

	public Employee savedetails(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
		
		
	}

	public ResponseEntity<Employee> updatedemployee(Long employeeId, Employee employeeDetails) {
		// TODO Auto-generated method stub
		 Employee employee = employeeRepository.findById(employeeId).orElseThrow();

			        employee.setEmailId(employeeDetails.getEmailId());
			        employee.setLastName(employeeDetails.getLastName());
			        employee.setFirstName(employeeDetails.getFirstName());
			        final Employee updatedEmployee = employeeRepository.save(employee);
			        return ResponseEntity.ok(updatedEmployee);
		
	}

	public Map<String, Boolean> deleteEmpId(Long employeeId){
		// TODO Auto-generated method stub
		 Optional<Employee> employee = employeeRepository.findById(employeeId);
			      
System.out.println("Hello Welcome delete"+employeeId);
			        employeeRepository.deleteById(employeeId);
			        Map<String, Boolean> response = new HashMap<>();
			        response.put("deleted", Boolean.TRUE);
			        return response;
		
	}

	public ResponseEntity<Employee> getAllEmployeesDetailsId(Long employeeId) throws ResourceNotFoundException
	{
	        Employee employee = employeeRepository.findById(employeeId)
	          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
	        return ResponseEntity.ok().body(employee);
	    }
	
    
}
