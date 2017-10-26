package com.myweb.core.test;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.myweb.core.dao.ShiftTypeDao;
import com.myweb.core.daoimpl.ShiftTypeImpl;
import com.myweb.core.persistence.entity.ShiftTypeEntity;

public class ShiftTypeTest {
	@Test
	public void checkFindAllShiftType() {
		ShiftTypeDao shiftTypeDao = new ShiftTypeImpl();
		List<ShiftTypeEntity> list = shiftTypeDao.findAll();
	}

	@Test
	public void checkUpdateShiftType() {
		ShiftTypeDao shiftTypeDao = new ShiftTypeImpl();
		ShiftTypeEntity entity = new ShiftTypeEntity((short) 2, "HOC");
		shiftTypeDao.update(entity);

	}

	@Test
	public void checkSaveShiftType() {
		ShiftTypeDao shiftTypeDao = new ShiftTypeImpl();
		ShiftTypeEntity entity = new ShiftTypeEntity((short) 5, "TAM");
		shiftTypeDao.save(entity);

	}

	@Test
	public void checkFindById() {
		ShiftTypeDao shiftTypeDao = new ShiftTypeImpl();
		ShiftTypeEntity entity = shiftTypeDao.findById((short) 1);
	}

	@Test
	public void checkFindByProperty() {
		ShiftTypeDao shiftTypeDao = new ShiftTypeImpl();
		String property = null;
		Object value = null;
		String sortExpression = null;
		String sortDirection = null;
		Object[] objects = shiftTypeDao.findByProperty(property, value, sortExpression, sortDirection);
	}

	@Test
	public void checkDelete() {
		ShiftTypeDao shiftTypeDao = new ShiftTypeImpl();
		List<Short> listId = new ArrayList<Short>();
		listId.add((short) 5);
		Integer count = shiftTypeDao.delete(listId);
	}
}
