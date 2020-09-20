/**
 * 
 */
package com.dm.yc.std.phn.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author Administrator
 */
public interface IBaseDao {
	public Session getSession();
	public void setSessionFactory(SessionFactory sessionFactory);
}
