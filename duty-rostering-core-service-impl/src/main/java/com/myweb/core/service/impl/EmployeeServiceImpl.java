package com.myweb.core.service.impl;

import com.myweb.core.dao.EmployeeDao;
import com.myweb.core.daoimpl.EmployeeDaoImpl;
import com.myweb.core.dto.EmployeeDTO;
import com.myweb.core.persistence.entity.EmployeeEntity;
import com.myweb.core.service.EmployeeService;
import com.myweb.core.utils.EmployeeBeanUtils;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public EmployeeDTO isEmployeeExist(EmployeeDTO dto) {
		EmployeeDao empDao = new EmployeeDaoImpl();
		EmployeeEntity entity = empDao.isEmployeeExist(dto.getUsername(), dto.getPassword());
		return EmployeeBeanUtils.entity2dto(entity);
	}

	@Override
	public EmployeeDTO findAdminEmployee(EmployeeDTO dto) {
		EmployeeDao empDao = new EmployeeDaoImpl();
		EmployeeEntity entity = empDao.findAdminEmployee(dto.getUsername(), dto.getPassword());
		return EmployeeBeanUtils.entity2dto(entity);
	}
}
