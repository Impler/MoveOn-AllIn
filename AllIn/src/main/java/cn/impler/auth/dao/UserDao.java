package cn.impler.auth.dao;

import cn.impler.auth.domain.User;
import cn.impler.auth.domain.dto.UserSearchBean;

/**
 * user dao
 * @author impler
 * @date 2017-01-11
 */
public interface UserDao extends AuthDao<User, Integer, UserSearchBean> {

	/**
	 * query user security information by username
	 * @param userName
	 * @return
	 */
	User querySecurityInfoByUserName(String userName);

	/**
	 * query user security information by mobile number
	 * @param mobileNumStr
	 * @return
	 */
	User querySecurityInfoByMobileNum(String mobileNumStr);

	/**
	 * query user security information by email address
	 * @param emailAddress
	 * @return
	 */
	User querySecurityInfoByEmailAddress(String emailAddress);

}
