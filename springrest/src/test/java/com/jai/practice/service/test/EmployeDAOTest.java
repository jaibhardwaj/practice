package com.jai.practice.service.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jai.practice.model.Employee;
import com.jai.practice.service.EmployeeDAO;
import com.jai.practice.service.HibernateEmployeeService;

public class EmployeDAOTest
{
	@Mock
	private EmployeeDAO employeeDao;
	private Employee emp;
	
	@BeforeClass
	private void beforClass()
	{
		MockitoAnnotations.initMocks(HibernateEmployeeService.class);
		emp = new Employee();
	}
	
	@Test
	public void testAddEmployee()
	{
		Mockito.when(employeeDao.addEmployee(emp)).thenReturn(emp);
		
		
		Employee newEMp = employeeDao.addEmployee(emp);
		assertNotNull(newEMp);
		assertEquals(emp.getId(), newEMp.getId());
		assertThrows(NullPointerException.class, () -> {
			throw new NullPointerException();
		});
	}

}
