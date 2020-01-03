package com.jai.practice.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.springframework.stereotype.Component;

@Component
public class DBConnection
{
	private static ResultSet rs;
	private static Statement stmt;
	private static Connection connection = null;
	private static Properties properties;
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			properties = new Properties();
			properties.load(new FileInputStream(new File("C:\\code\\practice\\springrest\\src\\main\\resources\\db.properties")));
		}
		catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	public static Connection getConnection()
	{
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
	
		try
		{	
			connection = DriverManager.getConnection(url, username, password);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return connection;
		
	}
	
	public static void main(String args[]) {
		String query = "select * from employee";
		Connection con = null;
		try { 
			// opening database connection to MySQL server
			con = getConnection();
			// getting Statement object to execute query
			stmt = con.createStatement();
			// executing SELECT query
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				String name = rs.getString("name");
				System.out.println("Name of EMployee in the table : " + name);
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			// close connection ,stmt and resultset here
			try {
				con.close();
			} catch (SQLException se) {
			}
			try {
				stmt.close();
			} catch (SQLException se) {
			}
			try {
				rs.close();
			} catch (SQLException se) {
				/* can't do anything */
			}

		}
	}
}
