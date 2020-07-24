package com.employeeCurd.starterApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.employeeCurd.StarterApp.controller"})
public class EmployeeCurdApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCurdApplication.class, args);
	}

}
