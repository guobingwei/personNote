/**
 * 
 */
package com.phn.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import antlr.collections.List;
import com.phn.dao.INavigationDao;
import com.phn.service.INavigationService;

/**
 * @author Administrator
 */
@Transactional
@Service("navigationService")
public class NavigationServiceImpl implements INavigationService {
	@Resource
	private INavigationDao navigationDao;
	
	@Override
	public List findnavigation() {
		return navigationDao.findnavigation();
	}
}
