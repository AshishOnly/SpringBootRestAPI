package com.assignment.SpringBootRestAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.SpringBootRestAPI.model.Employee;
import com.assignment.SpringBootRestAPI.service.EmpService;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

	@Autowired
	EmpService empService;

	@GetMapping("/employees")
	public List<Employee> fetchAllEmp() {
		return empService.getAllEmployees();
	}

	@PostMapping("/employee")
	public void addEmployee(@RequestBody Employee emp) {
		empService.addEmployee(emp);
	}

}
