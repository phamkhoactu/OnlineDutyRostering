package com.myweb.core.common.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static final SessionFactory sessionFactory = builSessionFactory();
	private static SessionFactory builSessionFactory() {
		try {
			// create sessionfactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
			
		} catch (Throwable e) {
			System.out.println("Initial Session Factory Fail" + e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
