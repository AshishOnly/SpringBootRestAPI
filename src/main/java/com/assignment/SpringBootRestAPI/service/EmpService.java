package com.assignment.SpringBootRestAPI.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.assignment.SpringBootRestAPI.model.Employee;
import com.assignment.SpringBootRestAPI.repository.EmpRepository;

@Service
public class EmpService {

	@Autowired
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
		Employee emp = new Employee();
		emp.setName(name);
		emp.setDesignation(designation);
		Example<Employee> example = Example.of(emp);
		List<Employee> employees = this.empRepo.findAll(example);
		return employees.stream().sorted().collect(Collectors.toList());
	}
	
	
	

}
