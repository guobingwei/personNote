/**
 * 
 */
package com.dm.yc.std.phn.service.impl;

import javax.annotation.Resource;

import com.dm.yc.std.phn.dao.INavigationDao;
import com.dm.yc.std.phn.model.NavigationEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.dm.yc.std.phn.service.INavigationService;

/**
 * @author Administrator
 */
@Transactional
@Service("navigationService")
public class NavigationServiceImpl implements INavigationService {
	@Resource
	private INavigationDao navigationDao;
	
	@Override
	public List<NavigationEntity> findnavigation() {
		return navigationDao.findnavigation();
	}
}
