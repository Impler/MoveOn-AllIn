package cn.impler.auth.service;

import java.util.List;

import cn.impler.auth.domain.Permission;
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
	 * @param username
	 * @return
	 */
	User querySecurityInfoByUsername(String username);

	/**
	 * query user common information by username(mobile/email address)
	 * @param username
	 * @return
	 */
	User queryCommonInfoByUsername(String username);

	/**
	 * query user permissions
	 * @param user
	 * @return
	 */
	List<Permission> queryUserPermissions(User user);

}
