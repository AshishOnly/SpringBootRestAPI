package com.assignment.SpringBootRestAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.SpringBootRestAPI.repository.EmpRepository;

@Service
public class EmpService {
	
	@Autowired
	EmpRepository empRepo;
	
	

}
