/**
 * 
 */
package com.phn.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.phn.dao.IBaseDao;
import com.phn.dao.INavigationDao;
import com.phn.model.NavigationEntity;

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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<NavigationEntity> findnavigation() {
		List<NavigationEntity> list = null;
		Session session = baseDao.getSession();
		String hql = "from NavigationEntity";
		Query query = session.createQuery(hql);
		list = query.list();
		System.out.println(list);
		return list;
	}

}
