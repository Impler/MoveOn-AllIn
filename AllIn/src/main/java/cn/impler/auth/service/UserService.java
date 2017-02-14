package cn.impler.auth.service;

import cn.impler.auth.domain.User;
import cn.impler.auth.domain.dto.UserSearchBean;

/**
 * user service
 * @author impler
 * @date 2017-01-11
 */
public interface UserService 
		extends AuthService<User, Integer, UserSearchBean>{

	/**
	 * query user security information by username(mobile/email address)
	 * @param userName
	 * @return
	 */
	User querySecurityInfoByUsername(String userName);

}
