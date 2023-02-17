package com.assignment.SpringBootRestAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.SpringBootRestAPI.model.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Long>{
	/*
	 * List<Employee> getAllEmployee(); void addEmployee(Employee emp); Employee
	 * updateEmployeeById(Long empId, Employee allDetails); //void
	 * deleteEmployeeById(long empId); void deleteAllEmployee(); Employee
	 *  Employee findEmployeeByDesignation(String designation);
	 */
	Employee findEmployeeByName(String name/* , String designation */);
}
