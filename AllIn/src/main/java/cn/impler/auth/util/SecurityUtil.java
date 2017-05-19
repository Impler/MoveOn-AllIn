package cn.impler.auth.util;

import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;

import cn.impler.auth.common.Constants;
import cn.impler.auth.domain.User;

public class SecurityUtil {

	public static User currentUser() {
		return (User) SecurityUtils.getSubject().getSession()
				.getAttribute(Constants.KEY_USER_IN_SESSION);
	}
	
	public static void keepUserInSession(User user){
		keepInSession(Constants.KEY_USER_IN_SESSION, user);
	}
	
	public static void keepInSession(Object key, Object value){
		SecurityUtils.getSubject().getSession().setAttribute(key, value);
	}
	
	/**
	 * encryptPassword
	 * @param originalPassword
	 * @return
	 */
	public static SimpleHash encryptPassword(String originalPassword){
		String salt = UUID.randomUUID().toString().replaceAll("-", "");
		return new SimpleHash("md5", originalPassword, salt);
	}
}
