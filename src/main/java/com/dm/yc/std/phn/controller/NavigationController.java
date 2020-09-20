/**
 * 
 */
package com.dm.yc.std.phn.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.dm.yc.std.phn.model.NavigationEntity;
import com.dm.yc.std.phn.service.INavigationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/navigation")
public class NavigationController {
	
	@Resource
	private INavigationService navigationService;
	
	@ResponseBody
	@RequestMapping(value="/find", method = RequestMethod.GET)
	public List<NavigationEntity> findnavagation(HttpServletRequest request) {
		List<NavigationEntity> list = new ArrayList<NavigationEntity>();
		list = (List<NavigationEntity>) navigationService.findnavigation();
		System.out.println(list.listIterator());
		request.setAttribute("list", list);
		
		return list;
	}
}
