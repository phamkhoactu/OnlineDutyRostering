package com.myweb.core.data.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<ID extends Serializable, T> {
	List<T> findAll();
	T update(T entity);
	void save(T entity);
	T findById(ID entityid);
	Object[] findByProperty(String property,Object value, String sortExpression, String sortDirection);
	
}
