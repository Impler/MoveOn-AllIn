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
	public User querySecurityInfoByUsername(String username) {
		
		return super.getDao().querySecurityInfoByUsername(username);
	}

	@Override
	public User querySecurityInfoByMobileNum(String mobileNumStr) {
		
		return super.getDao().querySecurityInfoByMobileNum(mobileNumStr);
	}

	@Override
	public User querySecurityInfoByEmailAddress(String emailAddress) {
	
		return super.getDao().querySecurityInfoByEmailAddress(emailAddress);
	}

	@Override
	public User queryCommonInfoByUsername(String username) {
		
		return super.getDao().queryCommonInfoByUsername(username);
	}

	@Override
	public User queryCommonInfoByMobileNum(String mobileNum) {

		return super.getDao().queryCommonInfoByMobileNum(mobileNum);
	}

	@Override
	public User queryCommonInfoByEmailAddress(String emailAddress) {

		return super.getDao().queryCommonInfoByEmailAddress(emailAddress);
	}

    @Override
    public int updateLockedStatus(User user) {
        return super.getDao().updateLockedStatus(user);
    }

}
