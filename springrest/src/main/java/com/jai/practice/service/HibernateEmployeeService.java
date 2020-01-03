package com.jai.practice.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.jai.practice.model.Employee;
import com.jai.practice.util.HibernateUtil;

@Component
@Qualifier("hibernate")
public class HibernateEmployeeService implements EmployeeDAO
{

	private static Logger LOG = LoggerFactory.getLogger(HibernateEmployeeService.class);
	private static final SessionFactory SESSION_FACTORY = HibernateUtil.getSessionFactory();
	
	@Override
	public Employee getEmployee(int id)
	{
		Session session = null;
		Employee employee = null;
		try
		{
			session = SESSION_FACTORY.openSession();
			employee = session.get(Employee.class, id);
		}
		catch (Exception e)
		{
			LOG.error("Error while getting employee with id {}", id);
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}

		return employee;
	}

	@Override
	public List<Employee> getAllEmployees()
	{
		Session session = null;
		List<Employee> employees = null;
		try
		{
			session = SESSION_FACTORY.openSession();
			Query<Employee> q = session.createQuery("from Employee");
			employees = q.list();
		}
		catch (Exception e)
		{
			LOG.error("Error while getting employees");
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}

		return employees;
	}

	@Override
	public Employee addEmployee(Employee employee)
	{
		Session session = null;
		try
		{
			session = SESSION_FACTORY.openSession();
			session.beginTransaction();
			session.saveOrUpdate(employee);
			session.getTransaction().commit();
		}
		catch (Exception e)
		{
			LOG.error("Error while adding employee with id {}", employee.getId());
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return employee;
	}

	@Override
	public void deleteEmployee(int id)
	{
		Session session = null;
		try
		{
			session = SESSION_FACTORY.openSession();
			Query<Employee> q = session.createQuery("delete from Employee where id = :id");
			session.beginTransaction();
			q.setParameter("id", id);
			q.executeUpdate();
			session.getTransaction().commit();
		}
		catch (Exception e)
		{
			LOG.error("Error while deleting employee with id {}", id);
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
	}

	public static void main(String[] args)
	{
		HibernateEmployeeService s = new HibernateEmployeeService();
		Employee e = new Employee();
		e.setId(2);
		e.setName("B");
		e.setDepartment("rr");
		e.setCountry("IN");
		e.setSalary("23232");
		s.addEmployee(e);
		s.getEmployee(2);
		s.deleteEmployee(2);
	}
}
