package cn.impler.auth.dao.impl;

import org.springframework.stereotype.Repository;

import cn.impler.auth.dao.AbsAuthDao;
import cn.impler.auth.dao.UserDao;
import cn.impler.auth.domain.User;
import cn.impler.auth.domain.dto.UserSearchBean;

/**
 * user dao implement
 * @author impler
 * @date 2017-01-11
 */
@Repository("userDao")
public class UserDaoImpl extends 
		AbsAuthDao<UserDao, User, Integer, UserSearchBean> implements
		UserDao {

	@Override
	public User querySecurityInfoByUserName(String userName) {
		
		return super.getDao().querySecurityInfoByUserName(userName);
	}

	@Override
	public User querySecurityInfoByMobileNum(String mobileNumStr) {
		
		return super.getDao().querySecurityInfoByMobileNum(mobileNumStr);
	}

	@Override
	public User querySecurityInfoByEmailAddress(String emailAddress) {
	
		return super.getDao().querySecurityInfoByEmailAddress(emailAddress);
	}

}
