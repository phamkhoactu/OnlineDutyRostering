package com.myweb.core.test;

import java.util.List;

import org.testng.annotations.Test;

import com.myweb.core.dao.ShiftTypeDao;
import com.myweb.core.daoimpl.ShiftTypeImpl;
import com.myweb.core.persistence.entity.ShiftTypeEntity;

public class ShiftTypeTest {
	@Test
	public void checkFindAll() {
		ShiftTypeDao shiftTypeDao = new ShiftTypeImpl();
		List<ShiftTypeEntity> list = shiftTypeDao.findAll();
	}
}
