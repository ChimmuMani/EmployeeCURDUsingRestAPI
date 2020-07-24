package com.employeeCurd.starterApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeCurd.starterApp.model.Employee;

@Repository
public interface EmployeeRepositary extends JpaRepository<Employee, Long>  {

}
