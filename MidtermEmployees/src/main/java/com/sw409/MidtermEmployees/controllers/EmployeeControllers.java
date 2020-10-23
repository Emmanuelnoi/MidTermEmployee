package com.sw409.MidtermEmployees.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sw409.MidtermEmployees.models.Employee;
import com.sw409.MidtermEmployees.services.EmployeeServices;

@RestController
@CrossOrigin("*")
public class EmployeeControllers {
	
	@Autowired
	EmployeeServices empServices;
	
	//Read
	@GetMapping("api/v1/employees")
	public ArrayList<Employee> getAllEmployee()
	{
		return empServices.getAllEmployee();
	}

	//CREATE
		@PostMapping("api/v1/employees")
		public Employee createEmployee(@RequestBody Employee employee)
		{
			return empServices.createsEmployee(employee);
			
		}
		
		
		//UPDATE
		@PutMapping("api/v1/employees/{employeesid}")
		public void updateEmployee(@PathVariable("Employeeid") Integer id, @RequestBody Employee employee)
		{
			empServices.updatesEmployee( id, employee);
		}
		//delete
		@DeleteMapping("api/v1/employees/{id}")
		public void deleteUser(@PathVariable Integer id)
		{
			empServices.deleteEmployee(id);
		}
}

