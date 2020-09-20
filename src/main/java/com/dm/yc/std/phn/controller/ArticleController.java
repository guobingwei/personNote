/**
 * 
 */
package com.dm.yc.std.phn.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.dm.yc.std.phn.model.Article;
import com.dm.yc.std.phn.service.IArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
