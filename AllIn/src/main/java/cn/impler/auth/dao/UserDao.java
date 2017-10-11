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
	 * @param username
	 * @return
	 */
	User querySecurityInfoByUsername(String username);

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

	/**
	 * query user common information by username
	 * @param username
	 * @return
	 */
	User queryCommonInfoByUsername(String username);

	/**
	 * query user common information by mobile number
	 * @param mobileNum
	 * @return
	 */
	User queryCommonInfoByMobileNum(String mobileNum);

	/**
	 * query user common information by email address
	 * @param emailAddress
	 * @return
	 */
	User queryCommonInfoByEmailAddress(String emailAddress);
	
	/**
	 * update user locked status
	 * @param user
	 */
	public int updateLockedStatus(User user);

}
