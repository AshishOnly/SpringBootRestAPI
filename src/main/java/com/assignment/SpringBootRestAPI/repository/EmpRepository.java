package com.assignment.SpringBootRestAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.SpringBootRestAPI.model.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Long>{
	
	

}
