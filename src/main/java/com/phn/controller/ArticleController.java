/**
 * 
 */
package com.phn.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phn.model.Article;
import com.phn.service.IArticleService;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("article")
public class ArticleController {

	@Resource
	private IArticleService articleService;
	
	@ResponseBody
	@RequestMapping(value = "/articleList", method = RequestMethod.GET)
	public List<Article> QueryArticle(HttpServletRequest request) {
		List<Article> list = new ArrayList<Article>();
		list = articleService.ArticleList();
		return list;
	} 
}
