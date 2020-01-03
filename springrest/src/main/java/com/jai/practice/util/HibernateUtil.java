package com.jai.practice.util;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil 
{
	
	private static final SessionFactory SESSION_FACTORY = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory()
	{
		SessionFactory sf = null;
		try {
			sf = new Configuration()
					.configure(new File("C:\\code\\practice\\springrest\\src\\main\\webapp\\WEB-INF\\hibernate.cfg.xml")).buildSessionFactory();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return sf;
	}
	
	public static SessionFactory getSessionFactory()
	{
		return SESSION_FACTORY;
	}
	
	public static void closeSessionFactory()
	{
		SESSION_FACTORY.close();
	}
	
	public static void main(String[] args) {
		System.out.println(SESSION_FACTORY);
	}
}
