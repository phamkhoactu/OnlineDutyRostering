package com.myweb.core.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.myweb.core.dao.EmployeeDao;
import com.myweb.core.daoimpl.EmployeeDaoImpl;
import com.myweb.core.dto.EmployeeDTO;
import com.myweb.core.persistence.entity.EmployeeEntity;
import com.myweb.core.service.EmployeeService;
import com.myweb.core.utils.EmployeeBeanUtils;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao empDao = new EmployeeDaoImpl();
	@Override
	public EmployeeDTO isEmployeeExist(EmployeeDTO dto) {
		EmployeeDao empDao = new EmployeeDaoImpl();
		EmployeeEntity entity = empDao.findEmployeeByUsernameAndPassword(dto.getUsername(), dto.getPassword());
		return EmployeeBeanUtils.entity2dto(entity);
	}

	@Override
	public EmployeeDTO checkEmployeeIsAdmin(EmployeeDTO dto) {
		EmployeeDao empDao = new EmployeeDaoImpl();
		EmployeeEntity entity = empDao.checkEmployeeIsAdmin(dto.getUsername(), dto.getPassword());
		return EmployeeBeanUtils.entity2dto(entity);
	}

	@Override
	public Object[] findEmployeeByProperties(Map< String, Object> property, String sortExpression, String sortDirection,
			Integer offset, Integer limit) {
		List<EmployeeDTO> result = new ArrayList<EmployeeDTO>();
		Object[] objects = empDao.findByProperty(property, sortExpression, sortDirection, offset, limit);
		for(EmployeeEntity item : (List<EmployeeEntity>) objects[1]) {
			EmployeeDTO dto = EmployeeBeanUtils.entity2dto(item);
			result.add(dto);
		}
		objects[1] = result;
		return objects;
	}

	@Override
	public EmployeeDTO findById(Short empId) {
		EmployeeEntity entity = empDao.findById(empId);
		EmployeeDTO dto =  EmployeeBeanUtils.entity2dto(entity);
		return dto;
	}

	@Override
	public void save(EmployeeDTO dto) {
		Timestamp createdDate = new Timestamp(System.currentTimeMillis());
		dto.setCreateDate(createdDate);
		//System.out.println(dto.getCreateDate());
		EmployeeEntity entity = EmployeeBeanUtils.dto2Entity(dto);
		empDao.save(entity);
		
	}

	@Override
	public EmployeeDTO update(EmployeeDTO dto) {
		EmployeeEntity entity = EmployeeBeanUtils.dto2Entity(dto);
		entity = empDao.update(entity);
		dto = EmployeeBeanUtils.entity2dto(entity);
		return dto;
	}

	@Override
	public Integer delete(List<Short> ids) {
		Integer result = empDao.delete(ids);
		return result;
	}
}
