/**
 * 
 */
package com.dm.yc.std.phn.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import com.dm.yc.std.phn.dao.IArticleDao;
import com.dm.yc.std.phn.dao.IBaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.dm.yc.std.phn.model.Article;

/**
 * @author Administrator
 */
@Repository("articleDao")
public class ArticleDaoImpl implements IArticleDao {

	/* (non-Javadoc)
	 * @see IArticleDao#ArticleList()
	 */
	@Resource
	public IBaseDao baseDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> ArticleList() {
		List<Article> list = null;
		Session session = baseDao.getSession();
		String hql = "from Article";
		Query query = session.createQuery(hql);
		list = query.list();
		return list;
	}

}
