package com.myweb.core.service;

import com.myweb.core.dto.EmployeeDTO;

public interface EmployeeService {
	EmployeeDTO isEmployeeExist(EmployeeDTO dto	);
	EmployeeDTO checkEmployeeIsAdmin(EmployeeDTO dto);
	Object[] findEmployeeByProperties(String property, Object value, String sortExpression, String sortDirection, Integer offset, Integer limit);
}
