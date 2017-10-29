package com.myweb.core.utils;

import com.myweb.core.dto.ShiftTypeDTO;
import com.myweb.core.persistence.entity.ShiftTypeEntity;

public class ShiftTypeBeanUtils {

	public static ShiftTypeDTO entity2Dto(ShiftTypeEntity entity) {
		ShiftTypeDTO dto = new ShiftTypeDTO();
		dto.setShiftTypeId(entity.getShiftTypeId());
		dto.setName(entity.getName());
		return dto;
	}

	public static ShiftTypeEntity dto2Entity(ShiftTypeDTO dto) {
		ShiftTypeEntity entity = new ShiftTypeEntity();
		entity.setShiftTypeId(dto.getShiftTypeId());
		entity.setName(dto.getName());
		return entity;
	}
}
