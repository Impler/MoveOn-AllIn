package cn.impler.auth.service.impl;

import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.impler.auth.dao.AuthDao;
import cn.impler.auth.dao.UserDao;
import cn.impler.auth.domain.User;
import cn.impler.auth.domain.dto.UserSearchBean;
import cn.impler.auth.service.AbsAuthService;
import cn.impler.auth.service.UserService;
import cn.impler.common.util.RegexUtil;

/**
 * user service implement
 * @author impler
 * @date 2017-01-11
 */
@Service("userService")
public class UserServiceImpl 
		extends AbsAuthService<User, Integer, UserSearchBean> 
		implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	protected AuthDao<User, Integer, UserSearchBean> getAuthDao() {
		return userDao;
	}

	@Override
	public User querySecurityInfoByUsername(String userName) {
		User user = userDao.querySecurityInfoByUserName(userName);
		
		if(null == user && RegexUtil.isMobileNumStr(userName)){
			user = userDao.querySecurityInfoByMobileNum(userName);
		}
		if(null == user && RegexUtil.isEmailAddressStr(userName)){
			user = userDao.querySecurityInfoByEmailAddress(userName);
		}
		
		if(null == user){
			throw new UnknownAccountException();
		}
		
		return user;
	}
	public static void main(String[] args) {
		SimpleHash hash = new SimpleHash("md5", "123", "1");
		System.out.println(hash);
	}


	

}
