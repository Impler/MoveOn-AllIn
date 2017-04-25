package cn.impler.auth.util;

import org.apache.shiro.SecurityUtils;

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
}
