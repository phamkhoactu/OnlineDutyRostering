package com.myweb.core.service;

import com.myweb.core.dto.EmployeeDTO;

public interface EmployeeService {
	EmployeeDTO isEmployeeExist(EmployeeDTO dto	);
	EmployeeDTO findAdminEmployee(EmployeeDTO dto);
}
