/**
 * 
 */
package com.dm.yc.std.phn.controller;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.dm.yc.std.phn.model.UserEntity;
import com.dm.yc.std.phn.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author phn
 */
@Controller
@RequestMapping("/user")
public class UserController{
	@Resource
	private IUserService userService;
	
	@ResponseBody
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public Map<String,Object> login( UserEntity user){
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println(user.toString());
		boolean loginResult = userService.isExist(user);
		map.put("loginResult", loginResult);
		return map;
	}
}
