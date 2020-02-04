package com.jai.practice.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jai.practice.model.Employee;

@RestController
public interface EmployeeRest
{
	@RequestMapping(value ="employee/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	ResponseEntity<Object> get(@PathVariable("id") String id);

	@RequestMapping(value = "employees", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Object> getAllEmployee();
	
	@RequestMapping(value="/employee", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Object> addEmployee(@RequestBody Employee newEmployee);
	
	@RequestMapping(value= "employee/{id}", method=RequestMethod.DELETE)
	ResponseEntity<Object> deleteEmployee(@PathVariable("id") String id);
}
