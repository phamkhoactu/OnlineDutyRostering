package com.myweb.core.dao;

import com.myweb.core.data.dao.GenericDao;
import com.myweb.core.persistence.entity.EmployeeEntity;

public interface EmployeeDao extends GenericDao<Short, EmployeeEntity>{
	EmployeeEntity findEmployeeByUsernameAndPassword(String username, String password);
	EmployeeEntity checkEmployeeIsAdmin(String username, String password);
	
}
