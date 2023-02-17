package com.assignment.SpringBootRestAPI.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.SpringBootRestAPI.model.Employee;
import com.assignment.SpringBootRestAPI.repository.EmpRepository;

@Service
public class EmpService {

	@Autowired
	EmpRepository empRepo;

	List<Employee> empList = new ArrayList<Employee>();

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
		empList.clear();
	}

	/*
	 * public List<Employee> findEmployeeByName(String name , String designation ){
	 * return empList.stream() .filter(e -> e.getName().equals(name) &&
	 * e.getDesignation().equals(designation) )
	 * .collect(Collectors.toList())findAny().orElse(null);
	 * 
	 * }
	 */

	public Employee findEmployeeByName(String name/* , String designation */) {
		return empList.stream().filter(e -> e.getName().equals(name) /* && e.getDesignation().equals(designation) */)
		/* .collect(Collectors.toList())*/.findAny().orElse(null) ;
	}

	

	/*
	 * public List<Employee> findEmployeeByName(String name , String designation ){
	 * List<Employee> emp = empList.stream() .filter(e -> e.getName().equals(name)
	 * && e.getDesignation().equals(designation) )
	 * .collect(Collectors.toList())findAny().orElse(null); return emp; }
	 */

}
