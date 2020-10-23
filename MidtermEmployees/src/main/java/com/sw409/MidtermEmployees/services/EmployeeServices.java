package com.sw409.MidtermEmployees.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw409.MidtermEmployees.Repositories.EmployeeRepository;
import com.sw409.MidtermEmployees.models.Employee;

@Service
public class EmployeeServices {
	
	ArrayList<Employee> employeeList =new ArrayList<>();
	@Autowired
	EmployeeRepository empRepository;
	
	//read
	public ArrayList<Employee>getAllEmployee()
	{
		return  (ArrayList<Employee>) empRepository.findAll();
	}

	//create
		public Employee createsEmployee(Employee employee)
		{
			//studentList.add(student);
			return empRepository.save(employee) ;
			
		}
	
		
		public void updatesEmployee(Integer id, Employee s)
		
		{
			Employee oldemployee = empRepository.findById(id).get();
			
			oldemployee.setEmp_name(s.getEmp_name());
			
			oldemployee.setEmp_title(s.getEmp_title());
			
			empRepository.save(s);
		}
		//Delete
		public void deleteEmployee(Integer id)
		{
			List<Employee> found = new ArrayList<>();
			for (Employee delEmployee : employeeList) {
				if (delEmployee.getEmp_id().equals(id)) {
					found.add(delEmployee);
				}
			}
			empRepository.deleteById(id);
		}
}
