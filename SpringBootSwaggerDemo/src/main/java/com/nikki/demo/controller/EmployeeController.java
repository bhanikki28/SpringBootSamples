package com.nikki.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikki.demo.model.Employee;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/employee")
@Api(value = "Employee Management", protocols = "http")
public class EmployeeController {
	
	ConcurrentHashMap<String,Employee> employees = new ConcurrentHashMap<>();
	
	@ApiOperation(value = "To access particular employee by passing the employee id", response = Employee.class, 
			code = 200)
	@GetMapping("/{id}")
	public Employee getContact(@PathVariable String id) {
		return employees.get(id);
		
	}
	
	@ApiOperation(value = "To get the list of employees", response = Employee.class, 
			code = 200)
	@GetMapping("/list")
	public List<Employee> getAllContacts(){
		return new ArrayList<Employee>(employees.values());
	}

	@ApiOperation(value = "To create an employee by passing the id,name,phone and designation", response = Employee.class, 
			code = 200)
	@PostMapping
	public Employee addContact(@RequestBody Employee contact) {
		employees.put(contact.getId(), contact);
		return contact;
		
	}

}
