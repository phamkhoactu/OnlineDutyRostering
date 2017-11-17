package com.myweb.api.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.myweb.core.dao.EmployeeDao;
import com.myweb.core.daoimpl.EmployeeDaoImpl;
import com.myweb.core.persistence.entity.EmployeeEntity;

public class LoginTest {
	private final Logger log = Logger.getLogger(this.getClass());
	
	
	@Test
//	public void checkFindEmployeeByProperties(){
//		EmployeeDao empDao = new EmployeeDaoImpl();
//		//Object[] result = empDao.findByProperty(null,null, null, null, 2, 3);	
//		if(result != null) {
//			log.error("findByProperties success");
//			System.out.println("-----------------------------------------");
//			List<EmployeeEntity> list = (List<EmployeeEntity>) result[1];
//			System.out.println(list.get(2).getFullName());
//			System.out.println("-----------------------------------------");
//		} else {
//			log.error("login fail");
//		}
//	}
	
	
	
	//@Test
	public void checkIsEmployeeExist() {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		String username = "admin";
		String password = "admin";
		EmployeeEntity entity = employeeDao.findEmployeeByUsernameAndPassword(username, password);
		
		if(entity != null) {
			log.error("login success");
		} else {
			log.error("login fail");
		}
	}
	
	//@Test
	public void checkFindAdminEmployee() {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		String username = "vy11544";
		String password = "123456";
		EmployeeEntity entity = employeeDao.checkEmployeeIsAdmin(username, password);
		
		if(entity.isIsAdmin()) {
			log.error("User is admin");
		} else {
			log.error("User not admin");
		}
	}
	
	//@Test
	public void checkFindByProperties() {
		
	}
}
