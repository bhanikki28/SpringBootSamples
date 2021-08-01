package com.nikki.jpa.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nikki.jpa.demo.entity.Employee;
import com.nikki.jpa.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	

	private final EmployeeRepository employeeRepo;
	
	public EmployeeService(EmployeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	public List<Employee> getAllEmployees(){
		return employeeRepo.findAll();
	}
	
	public Employee getEmployee(String id){
		return employeeRepo.getById(id);
	}
	

}
