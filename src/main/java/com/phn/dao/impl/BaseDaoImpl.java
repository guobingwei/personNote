/**
 * 
 */
package com.phn.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.phn.dao.IBaseDao;

/**
 * @author Administrator
 */
@Repository("baseDao")
public class BaseDaoImpl implements IBaseDao{

	@Resource
	public SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.phn.dao.IBaseDao#getSession()
	 */
	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/* (non-Javadoc)
	 * @see com.phn.dao.IBaseDao#setSessionFactory(org.hibernate.SessionFactory)
	 */
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
	}
	
   /* @Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
    @Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/
}
