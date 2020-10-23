package com.sw409.MidtermEmployees.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.sw409.MidtermEmployees.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	

}
