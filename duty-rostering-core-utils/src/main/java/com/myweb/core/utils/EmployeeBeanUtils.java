package com.myweb.core.utils;

import com.myweb.core.dto.EmployeeDTO;
import com.myweb.core.dto.ShiftTypeDTO;
import com.myweb.core.persistence.entity.EmployeeEntity;
import com.myweb.core.persistence.entity.ShiftTypeEntity;

public class EmployeeBeanUtils {
	public static EmployeeDTO entity2dto(EmployeeEntity entity) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpId(entity.getEmpId());
		dto.setUsername(entity.getUsername());
		dto.setPassword(entity.getPassword());
		dto.setFullName(entity.getFullName());
		dto.setCreateDate(entity.getCreateDate());
		dto.setAdmin(entity.isIsAdmin());
		dto.setActive(entity.isIsActive());

		return dto;
	}

	public static EmployeeEntity dto2Entity(EmployeeDTO dto) {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setEmpId(dto.getEmpId());
		entity.setUsername(dto.getUsername());
		entity.setPassword(dto.getPassword());
		entity.setFullName(dto.getFullName());
		entity.setCreateDate(dto.getCreateDate());
		entity.setIsAdmin(dto.isAdmin());
		entity.setIsActive(dto.isActive());

		return entity;
	}
}
