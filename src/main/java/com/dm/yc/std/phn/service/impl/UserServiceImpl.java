/**
 * 
 */
package com.dm.yc.std.phn.service.impl;

import javax.annotation.Resource;

import com.dm.yc.std.phn.dao.IUserDao;
import com.dm.yc.std.phn.model.UserEntity;
import com.dm.yc.std.phn.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author phn
 */
@Transactional
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;

	@Override
	public boolean isExist(UserEntity user) {
		return userDao.isExist(user);
	}

}
