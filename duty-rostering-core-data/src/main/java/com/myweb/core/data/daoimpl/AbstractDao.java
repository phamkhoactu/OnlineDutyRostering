package com.myweb.core.data.daoimpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myweb.core.common.utils.HibernateUtils;
import com.myweb.core.data.dao.GenericDao;

public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID, T> {
	private Class<T> persistenceClass;
	
	
	
	public AbstractDao() {
		this.persistenceClass =  (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}

	protected Session getSession() {
		return HibernateUtils.getSessionFactory().openSession();
	}
	
	public String getPersistenceClassName() {
		return persistenceClass.getSimpleName();
	}

	@Override
	public List<T> findAll() {
		List<T> list = new ArrayList<T>();
		Transaction transaction = null;
		try {
			transaction = getSession().beginTransaction();
			//HQL
			StringBuilder sql = new StringBuilder("from ");
			sql.append(this.getPersistenceClassName());
			Query query = this.getSession().createQuery(sql.toString());
			list = query.list();
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			System.out.println("Running findAll() fail\n");
			throw e;
		} finally {
			
		}
		
		return list;
	}

}
