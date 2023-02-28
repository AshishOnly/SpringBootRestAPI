package com.assignment.SpringBootRestAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee implements Comparable<Employee> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long id;

	@Column(name = "emp_name")
	private String name;

	@Column(name = "designation")
	private String designation;

	@Column(name = "department")
	private String department;

	public Employee() {
		super();
	}

	public Employee(Long id, String name, String designation, String department) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public int compareTo(Employee o) {

		return this.name.compareTo(o.getName());
	}

}
