/**
 * 
 */
package com.dm.yc.std.phn.dao;

import com.dm.yc.std.phn.model.UserEntity;

/**
 * @author phn
 */
public interface IUserDao {
	public boolean isExist(UserEntity user);
}
