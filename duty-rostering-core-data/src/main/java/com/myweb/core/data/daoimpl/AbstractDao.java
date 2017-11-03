package com.myweb.core.data.daoimpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myweb.core.common.constant.CoreConstant;
import com.myweb.core.common.utils.HibernateUtils;
import com.myweb.core.data.dao.GenericDao;

import javassist.tools.rmi.ObjectNotFoundException;

public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID, T> {
	private Class<T> persistenceClass;

	public AbstractDao() {
		this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	public String getPersistenceClassName() {
		return persistenceClass.getSimpleName();
	}

	@Override
	public List<T> findAll() {
		List<T> list = new ArrayList<T>();
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// HQL
			StringBuilder sql = new StringBuilder("from ");
			sql.append(this.getPersistenceClassName());
			Query query = session.createQuery(sql.toString());
			list = query.list();
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			System.out.println("Running findAll() fail\n");
			throw e;
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public T update(T entity) {
		T result = null;
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Object object = session.merge(entity);
			result = (T) object;
			transaction.commit();
		} catch (HibernateException he) {
			transaction.rollback();
			System.out.println("Running update() fail\n");
			throw he;

		} finally {
			session.close();
		}
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public void save(T entity) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.persist(entity);
			transaction.commit();
		} catch (HibernateException he) {
			transaction.rollback();
			System.out.println("Running save() fail\n");
			throw he;

		} finally {
			session.close();
		}

	}

	@Override
	public T findById(ID id) {
		T result = null;
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			result = (T) session.get(persistenceClass, id);
			if (result == null) {
				throw new ObjectNotFoundException("Not Found " + id, null);
			}
		} catch (HibernateException he) {
			transaction.rollback();
			System.out.println("Running findById() fail\n");
			throw he;

		} catch (ObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public Object[] findByProperty(String property, Object value, String sortExpression, String sortDirection,
			Integer offset, Integer limit) {
		List<T> list = new ArrayList<T>();
		Transaction transaction = null;
		Session session = null;
		Object totalItem = null;
		try {
			totalItem = 0;
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			StringBuilder sql1 = new StringBuilder(" from ");
			sql1.append(getPersistenceClassName());
			if (property != null && value != null) {
				sql1.append(" where ").append(property).append("= :value");
			}

			if (sortExpression != null && sortDirection != null) {
				sql1.append(" order by ").append(sortDirection);
				sql1.append(" " + (sortDirection.equals(CoreConstant.SORT_ASC) ? "asc" : "desc"));

			}
			Query query1 = session.createQuery(sql1.toString());
			if (value != null) {
				query1.setParameter("value", value);
			}

			if (offset != null && offset >= 0) {
				query1.setFirstResult(offset);
			}
			if (limit != null && limit > 0) {
				query1.setMaxResults(limit);
			}

			list = query1.list();
			StringBuilder sql2 = new StringBuilder("select count(*) from ");
			sql2.append(getPersistenceClassName());
			if (property != null && value != null) {
				sql2.append(" where ").append(property).append("= :value");
			}
			Query query2 = session.createQuery(sql2.toString());

			if (value != null) {
				query2.setParameter("value", value);
			}
			totalItem = query2.list().get(0);
			transaction.commit();

		} catch (HibernateException he) {
			transaction.rollback();
			System.out.println("Running findByProperty() fail\n");
			throw he;

		} finally {
			session.close();
		}
		return new Object[] { totalItem, list };
	}

	@Override
	public Integer delete(List<ID> ids) {
		Integer count = null;
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			count = 0;
			for (ID item : ids) {
				T t = (T) session.get(persistenceClass, item);
				session.delete(t);
				count++;
			}

			transaction.commit();
		} catch (HibernateException he) {
			transaction.rollback();
			System.out.println("Running delete() fail\n");
			throw he;

		} finally {
			session.close();
		}
		// TODO Auto-generated method stub
		return count;
	}

}
