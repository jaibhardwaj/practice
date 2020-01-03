package com.jai.practice.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.jai.practice.db.DBConnection;
import com.jai.practice.model.Employee;

@Component
@Qualifier("jdbc")
public class EmployeeService implements EmployeeDAO
{
	private PreparedStatement preparedStatement = null;
	
	private static Logger LOG = LoggerFactory.getLogger(EmployeeService.class);
	/*
	 * private DataSource dataSource;
	 * 
	 * public void setDataSource(DataSource dataSource) { this.dataSource =
	 * dataSource; }
	 */

	@Override
	public Employee getEmployee(int id)
	{
		String query = "select * from employee where id = ?;";
		Connection connection = DBConnection.getConnection();
		ResultSet resultSet = null;
		Employee employee = new Employee();
		
		try
		{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next())
			{
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setSalary(resultSet.getString("salary"));
				employee.setDepartment(resultSet.getString("department"));
				employee.setCountry(resultSet.getString("department"));
			}
		}
		catch (SQLException ex)
		{
			LOG.error("Error while getting employee with id {}", id);
			ex.printStackTrace();
		}
		finally
		{
			if (connection != null)
			{
				try
				{
					connection.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return employee;

	}
	
	
	
	//Using Spring JDBC
	/*
	 * public Employee getEmployee(int id) { String query =
	 * "select * from employee where id = ?;"; JdbcTemplate jdbcTemplate = new
	 * JdbcTemplate(dataSource); Employee emp = jdbcTemplate.queryForObject(query,
	 * new Object[] {id}, new RowMapper<Employee>(){
	 * 
	 * @Override public Employee mapRow(ResultSet rs, int rowNum) throws
	 * SQLException { Employee emp = new Employee(); emp.setId(rs.getInt("id"));
	 * emp.setName(rs.getString("name")); emp.setSalary(rs.getString("salary"));
	 * emp.setCountry(rs.getString("country"));
	 * emp.setDepartment(rs.getString("department")); return emp; }}); return emp;
	 * 
	 * }
	 */
		
	@Override
	public List<Employee> getAllEmployees()
	{
		String query = "select * from employee";
		Connection connection = DBConnection.getConnection();
	    ResultSet resultSet = null;
	    List<Employee> employeeList = new ArrayList<Employee>();
	    
		try
		{
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Employee employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setSalary(resultSet.getString("salary"));
				employee.setDepartment(resultSet.getString("department"));
				employee.setCountry(resultSet.getString("country"));
				employeeList.add(employee);
			}
		}
		catch (SQLException ex)
		{
			LOG.error("Error while getting employees");
			ex.printStackTrace();
		}
		finally
		{
			if(connection != null)
			{
				try
				{
					connection.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return employeeList;
		
	}
	
	@Override
	public Employee addEmployee(Employee employee)
	{
		String query = "insert into employee values (?, ?, ?, ?, ?);";
		Connection connection = DBConnection.getConnection();
	    try 
		{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setString(3, employee.getSalary());
			preparedStatement.setString(4, employee.getDepartment());
			preparedStatement.setString(5, employee.getCountry());
			preparedStatement.executeUpdate();
		}
		catch (SQLException ex)
		{
			LOG.error("Error while adding employee with id {}", employee.getId());
			ex.printStackTrace();
		}
		finally
		{
			if(connection != null)
			{
				try
				{
					connection.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return employee;
		
	}
	
	@Override
	public void deleteEmployee(int id)
	{
		String query = "delete from employee where id = ?;";
		Connection connection = DBConnection.getConnection();
		try 
		{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		}
		catch (SQLException ex)
		{
			LOG.error("Error while deleting employee with id {}", id);
			ex.printStackTrace();
		}
		finally
		{
			if(connection != null)
			{
				try
				{
					connection.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}		
	}
	
	public static void main(String[] args)
	{
		/*
		 * EmployeeService es = new EmployeeService(); List<Employee> e =
		 * es.getAllEmployees(); System.out.println(e);
		 */
		EmployeeService es = new EmployeeService();
		/*
		 * Employee e = new Employee(); e.setId(2); e.setName("sachin");
		 * e.setSalary("8765456"); e.setDepartment("fds"); e.setCountry("uk");
		 * es.addEmployee(e);
		 */
		es.deleteEmployee(3);
	}

}
