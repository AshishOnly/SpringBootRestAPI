package com.assignment.SpringBootRestAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.SpringBootRestAPI.model.Employee;
import com.assignment.SpringBootRestAPI.service.EmpService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	EmpService empService;
	
	@GetMapping("/employees")
	public List<Employee> fetchAllEmp(){
		return empService.getAllEmployees();
	}
	
	@PostMapping("/employees")
	public void addEmp(@RequestBody Employee employee) {
		empService.addEmployee(employee);
	}

	@PostMapping("/employees/{id}")
	public Employee updateEmp(@PathVariable(value="empId") long empId, @RequestBody Employee allDetails) {
		return empService.updateEmployeeById(empId, allDetails);
	}
	
	@DeleteMapping("/deleteAllEmployees")
	public void deleteEmp() {
		empService.deleteAllEmployee();
	}
	
}
