package com.nikki.jpa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikki.jpa.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{
	

}
