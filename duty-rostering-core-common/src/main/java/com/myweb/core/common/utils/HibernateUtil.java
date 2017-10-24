package com.myweb.core.common.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory SESSION_FACTORY = HibernateUtil.buildSessionFacotry(); 
	private static SessionFactory buildSessionFacotry() {
		try {
			// Create Session Factory from Hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
			
		} catch (Throwable e) {
			System.out.println("Initial Session Factory Fail");
			throw new ExceptionInInitializerError(e); 
		}
	}
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}
