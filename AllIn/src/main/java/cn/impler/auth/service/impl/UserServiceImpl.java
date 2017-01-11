package cn.impler.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.impler.auth.dao.AuthDao;
import cn.impler.auth.dao.UserDao;
import cn.impler.auth.domain.User;
import cn.impler.auth.domain.dto.UserSearchBean;
import cn.impler.auth.service.AbsAuthService;
import cn.impler.auth.service.UserService;

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



	

}
