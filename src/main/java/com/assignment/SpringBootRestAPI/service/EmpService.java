package com.assignment.SpringBootRestAPI.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.assignment.SpringBootRestAPI.model.Employee;
import com.assignment.SpringBootRestAPI.repository.EmpRepository;

@Service
public class EmpService {


	private EmpRepository empRepo;
	
	public EmpService(EmpRepository empRepo ) {
		this.empRepo = empRepo;
	}

	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}
	
	
	public Employee addEmployee(Employee emp) {
		return empRepo.save(emp);
	}

	public Employee updateEmployeeById(Long empId, Employee allDetails) {
		Employee emp = empRepo.findById(empId).get();
		emp.setName(allDetails.getName());
		emp.setDesignation(allDetails.getDesignation());
		emp.setDepartment(allDetails.getDepartment());

		return empRepo.save(emp);
	}

	/*
	 * public void deleteEmployeeByID(long empId) { empRepo.deleteById(empId); }
	 */

	public void deleteAllEmployee() {
		this.empRepo.deleteAll();
	}

	public List<Employee> findEmpByNameAndDesignation(String name, String designation) {
		Employee exampleEmp = new Employee();
		exampleEmp.setName(name);
		exampleEmp.setDesignation(designation);
		Example<Employee> example = Example.of(exampleEmp);
		List<Employee> employees = this.empRepo.findAll(example);
		return employees.stream().sorted().collect(Collectors.toList());
	}
	
	
	

}
