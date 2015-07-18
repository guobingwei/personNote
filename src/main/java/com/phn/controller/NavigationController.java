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

import com.phn.model.NavigationEntity;
import com.phn.service.INavigationService;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/navigation")
public class NavigationController {
	
	@Resource
	private INavigationService navigationService;
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value="/find", method = RequestMethod.GET)
	public String findnavagation(HttpServletRequest request) {
		List<NavigationEntity> list = new ArrayList<NavigationEntity>();
		list = (List<NavigationEntity>) navigationService.findnavigation();
		System.out.println(list.listIterator());
		request.setAttribute("list", list);
		
		return "index";
	}
}
