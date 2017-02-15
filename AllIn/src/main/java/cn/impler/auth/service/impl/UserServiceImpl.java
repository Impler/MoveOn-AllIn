package cn.impler.auth.service.impl;

import java.util.List;

import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.impler.auth.dao.AuthDao;
import cn.impler.auth.dao.PermissionDao;
import cn.impler.auth.dao.UserDao;
import cn.impler.auth.domain.Permission;
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

	@Autowired
	private PermissionDao permissionDao;
	
	@Override
	protected AuthDao<User, Integer, UserSearchBean> getAuthDao() {
		return userDao;
	}

	@Override
	public User querySecurityInfoByUsername(String username) {
		User user = userDao.querySecurityInfoByUsername(username);
		
		if(null == user && RegexUtil.isMobileNumStr(username)){
			user = userDao.querySecurityInfoByMobileNum(username);
		}
		if(null == user && RegexUtil.isEmailAddressStr(username)){
			user = userDao.querySecurityInfoByEmailAddress(username);
		}
		
		if(null == user){
			throw new UnknownAccountException();
		}
		
		return user;
	}

	@Override
	public User queryCommonInfoByUsername(String username) {
		User user = userDao.queryCommonInfoByUsername(username);
		
		if(null == user && RegexUtil.isMobileNumStr(username)){
			user = userDao.queryCommonInfoByMobileNum(username);
		}
		if(null == user && RegexUtil.isEmailAddressStr(username)){
			user = userDao.queryCommonInfoByEmailAddress(username);
		}
		
		if(null == user){
			throw new UnknownAccountException();
		}
		
		return user;
	}

	@Override
	public List<Permission> queryUserPermissions(User user) {
		return null;
	}


	

}
