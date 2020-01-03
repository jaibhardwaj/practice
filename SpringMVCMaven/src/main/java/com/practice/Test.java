package com.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test
{
	
	public static void main(String[] args)
	{
		/*
		 * Test test = new Test(); ApplicationContext context = new
		 * ClassPathXmlApplicationContext(); Drawing d = (Drawing)
		 * context.getBean(Drawing.class); d.drawShape();
		 */
		
		System.out.println(m1());
	}
	
	public static int m1()
	{
		try
		{
			return 1;
		}
		catch(Exception e)
		{
			return 2;
		}
		finally
		{
			return 3;
		}
	}

}
