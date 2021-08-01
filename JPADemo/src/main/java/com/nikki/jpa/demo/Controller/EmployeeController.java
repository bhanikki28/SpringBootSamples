package com.nikki.jpa.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nikki.jpa.demo.entity.Employee;
import com.nikki.jpa.demo.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/employee")
@Api(value = "Employee Management", protocols = "http")
public class EmployeeController {
	

	@Autowired
	private EmployeeService empService;
	
	@ApiOperation(value = "To get the list of employees", response = Employee.class, 
			code = 200)
	@GetMapping("/list")
	public List<Employee> getAllEmployees(){
		return empService.getAllEmployees();
	}
	
	
	@ApiOperation(value = "To access particular employee by passing the employee id", response = Employee.class, 
			code = 200)
	@GetMapping(value="/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Employee getEmployee(@PathVariable String id) {
		return empService.getEmployee(id);
		
	}
	/*
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
		
	}*/

}
