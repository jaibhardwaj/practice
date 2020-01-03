package com.jai.practice.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jai.practice.model.Employee;

public interface EmployeeDAO
{
	Employee getEmployee(int id);
	
	List<Employee> getAllEmployees();
	
	Employee addEmployee(Employee employee);
	
	void deleteEmployee(int id);
}
