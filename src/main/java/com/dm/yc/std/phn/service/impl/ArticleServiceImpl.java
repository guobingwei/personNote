/**
 * 
 */
package com.dm.yc.std.phn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.dm.yc.std.phn.dao.IArticleDao;
import com.dm.yc.std.phn.model.Article;
import com.dm.yc.std.phn.service.IArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 */
@Transactional
@Service("articleService")
public class ArticleServiceImpl implements IArticleService {

	/* (non-Javadoc)
	 * @see IArticleService#ArticleList()
	 */
	@Resource
	private IArticleDao articleDao;
	@Override
	public List<Article> ArticleList() {
		
		return articleDao.ArticleList();
	}

}
