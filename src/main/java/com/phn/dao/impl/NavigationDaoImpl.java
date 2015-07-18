/**
 * 
 */
package com.phn.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import antlr.collections.List;

import com.phn.dao.IBaseDao;
import com.phn.dao.INavigationDao;

/**
 * @author Administrator
 */
@Repository("navigationDao")
public class NavigationDaoImpl implements INavigationDao {

	@Resource
	public IBaseDao baseDao;
	
	@Resource
	protected SessionFactory sessionFactory;


	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List findnavigation() {
		Session session = baseDao.getSession();
		String hql = "select NavigationName from NavigationEntity";
		Query query = session.createQuery(hql);
		List list = (List) query.list();
		return list;
	}

}
