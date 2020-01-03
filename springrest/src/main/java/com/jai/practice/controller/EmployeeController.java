package com.jai.practice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jai.practice.model.Employee;
import com.jai.practice.service.EmployeeDAO;
import com.jai.practice.util.ResponseMessage;

@RestController
public class EmployeeController
{
	
	
	public static Logger LOG = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired()
	@Qualifier("hibernate")
	private EmployeeDAO employeeDAO;
	
	@RequestMapping(value ="employee/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> get(@PathVariable("id") String id)
	{
		LOG.info("Get Employee for ID : {}", id);
		Employee employee = null;
		if(id != null)
		{
			employee = employeeDAO.getEmployee(Integer.parseInt(id));
		}
		if(employee == null)
		{
			ResponseMessage rs = new ResponseMessage("Failed", "Employee Not Found!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(rs);
		}
		return ResponseEntity.status(HttpStatus.OK).body(employee);
		
	}
	
	@RequestMapping(value = "employees", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getAllEmployee()
	{
		LOG.info("Get All Employees");
		List<Employee> employees = employeeDAO.getAllEmployees();
		if(employees == null)
		{
			ResponseMessage rs = new ResponseMessage("Failed", "Resouces Not Found!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(rs);
		}
		return ResponseEntity.status(HttpStatus.OK).body(employees);
		
	}
	
	@RequestMapping(value="/employee", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addEmployee(@RequestBody Employee newEmployee)
	{
		LOG.info("Add Employee with ID : {}", newEmployee.getId());
		Employee employee = employeeDAO.addEmployee(newEmployee);
		if(employee == null)
		{
			ResponseMessage rs = new ResponseMessage("Failed", "Unable to Add Employee");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(rs);
		}
		ResponseMessage rs = new ResponseMessage("success", "Employee Data Added Successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(rs);
		
	}
	
	@RequestMapping(value= "employee/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteEmployee(@PathVariable("id") String id)
	{
		LOG.info("Delete Employee for ID : {}", id);
		Employee employee = null;
		if(id != null)
		{
			
			employee = employeeDAO.getEmployee(Integer.parseInt(id));
			employeeDAO.deleteEmployee(Integer.parseInt(id));
		}
		else
		{
			ResponseMessage rs = new ResponseMessage("Failed", "Employee ID Null!");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(rs);
		}
		if(employee == null)
		{
			ResponseMessage rs = new ResponseMessage("Failed", "Employee Not Found!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(rs);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(employee);
		
	}
}
