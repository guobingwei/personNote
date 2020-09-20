/**
 * 
 */
package com.dm.yc.std.phn.dao.impl;

import javax.annotation.Resource;

import com.dm.yc.std.phn.dao.IBaseDao;
import com.dm.yc.std.phn.dao.INavigationDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.dm.yc.std.phn.model.NavigationEntity;

/**
 * @author Administrator
 */
@Repository("navigationDao")
public class NavigationDaoImpl implements INavigationDao {

	@Resource
	public IBaseDao baseDao;
	
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
