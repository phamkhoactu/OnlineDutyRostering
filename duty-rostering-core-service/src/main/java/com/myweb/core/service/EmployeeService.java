package com.myweb.core.service;

import java.util.List;
import java.util.Map;

import com.myweb.core.dto.EmployeeDTO;

public interface EmployeeService {
	EmployeeDTO isEmployeeExist(EmployeeDTO dto	);
	EmployeeDTO checkEmployeeIsAdmin(EmployeeDTO dto);
	Object[] findEmployeeByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);
	EmployeeDTO findById(Short empId);
	void save(EmployeeDTO dto);
	EmployeeDTO update(EmployeeDTO dto);
	Integer delete(List<Short> ids);
}
