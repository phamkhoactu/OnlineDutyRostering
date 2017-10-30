package com.myweb.core.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myweb.core.common.utils.HibernateUtils;
import com.myweb.core.dao.EmployeeDao;
import com.myweb.core.data.daoimpl.AbstractDao;
import com.myweb.core.persistence.entity.EmployeeEntity;

public class EmployeeDaoImpl extends AbstractDao<Short, EmployeeEntity> implements EmployeeDao {

	@Override
	public EmployeeEntity isEmployeeExist(String username, String password) {
		EmployeeEntity entity = null;
		Transaction transaction = null;
		Session session = null;
		try {
			entity = new EmployeeEntity();
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			StringBuilder sql = new StringBuilder(
					"FROM EmployeeEntity WHERE username= :username AND password= :password");
			Query query = session.createQuery(sql.toString());
			query.setParameter("username", username);
			query.setParameter("password", password);
			
			entity = (EmployeeEntity) query.uniqueResult();
			transaction.commit();
		} catch (HibernateException he) {
			transaction.rollback();
			throw he;
		} finally {
			session.close();
		}

		return entity;
	}

	@Override
	public EmployeeEntity findAdminEmployee(String username, String password) {
		EmployeeEntity entity = null;
		Transaction transaction = null;
		Session session = null;
		try {
			entity = new EmployeeEntity();
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			StringBuilder sql = new StringBuilder(
					"FROM EmployeeEntity WHERE username= :username AND password= :password");
			Query query = session.createQuery(sql.toString());
			query.setParameter("username", username);
			query.setParameter("password", password);
			
			entity = (EmployeeEntity) query.uniqueResult();
			transaction.commit();
		} catch (HibernateException he) {
			transaction.rollback();
			throw he;
		} finally {
			session.close();
		}

		return entity;
	}

}
