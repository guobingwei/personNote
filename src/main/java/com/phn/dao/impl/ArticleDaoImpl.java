/**
 * 
 */
package com.phn.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.phn.dao.IArticleDao;
import com.phn.dao.IBaseDao;
import com.phn.model.Article;

/**
 * @author Administrator
 */
@Repository("articleDao")
public class ArticleDaoImpl implements IArticleDao {

	/* (non-Javadoc)
	 * @see com.phn.dao.IArticleDao#ArticleList()
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
