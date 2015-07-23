/**
 * 
 */
package com.phn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phn.dao.IArticleDao;
import com.phn.model.Article;
import com.phn.service.IArticleService;

/**
 * @author Administrator
 */
@Transactional
@Service("articleService")
public class ArticleServiceImpl implements IArticleService {

	/* (non-Javadoc)
	 * @see com.phn.service.IArticleService#ArticleList()
	 */
	@Resource
	private IArticleDao articleDao;
	@Override
	public List<Article> ArticleList() {
		
		return articleDao.ArticleList();
	}

}
