package com.assignment.SpringBootRestAPI.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.SpringBootRestAPI.model.Employee;
import com.assignment.SpringBootRestAPI.service.EmpService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmpService empService;
	/*
	 * @GetMapping("/manualEmp") public List<Employee> getEmployess(){
	 * List<Employee> empList=new ArrayList<Employee>(); empList.add(new
	 * Employee((long) 1,"tet","test","test")); return empList; }
	 */
	
	@GetMapping("/employees")
	public List<Employee> fetchAllEmp(){
		return empService.getAllEmployees();
	}
	
	@PostMapping("/employees")
	public void addEmployee(@RequestBody Employee emp) {
		empService.addEmployee(emp);
	}

	@PutMapping("/employees/{id}")
	public Employee updateEmp(@PathVariable(value="id") Long id, @RequestBody Employee allDetails) {
		return empService.updateEmployeeById(id, allDetails);
	}
	
	@DeleteMapping("/deleteAllEmployees")
	public void deleteEmp() {
		empService.deleteAllEmployee();
	}
	
	@GetMapping("/findByName/{name}")
	public Employee findEmployeeByName(@PathVariable String name){
		return empService.findEmployeeByName(name);
	}
	
	
	/*
	 * @GetMapping("/findByName/{name}") public List<Employee>
	 * findEmployeeByName(@PathVariable String name){ return
	 * empService.findEmployeeByName(name); }
	 */
	
}
