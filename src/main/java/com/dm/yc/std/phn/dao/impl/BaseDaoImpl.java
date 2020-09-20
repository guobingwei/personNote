/**
 * 
 */
package com.dm.yc.std.phn.dao.impl;

import javax.annotation.Resource;

import com.dm.yc.std.phn.dao.IBaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 */
@Repository("baseDao")
public class BaseDaoImpl implements IBaseDao {

	@Resource
	public SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see IBaseDao#getSession()
	 */
	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/* (non-Javadoc)
	 * @see IBaseDao#setSessionFactory(org.hibernate.SessionFactory)
	 */
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
	}
}
