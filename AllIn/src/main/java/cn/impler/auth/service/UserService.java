package cn.impler.auth.service;

import cn.impler.auth.domain.LoginDetail;
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
	 * save login detail information
	 * @param detail
	 */
	void saveLoginDetail(User user, LoginDetail detail);

	/**
	 * check user status
	 * @param user
	 */
    void checkUserStatus(User user);
	
}
