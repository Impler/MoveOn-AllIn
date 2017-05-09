package cn.impler.auth.shiro.listener;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationListener;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import cn.impler.auth.domain.User;
import cn.impler.auth.service.UserService;
import cn.impler.auth.util.SecurityUtil;

public class AllInAuthenticationListener implements AuthenticationListener {

	@Autowired
	private UserService userService;
	
	@Override
	public void onSuccess(AuthenticationToken token, AuthenticationInfo info) {
		String username = (String) token.getPrincipal();
		User user = userService.queryCommonInfoByUsername(username);
		Assert.notNull(user);
		SecurityUtil.keepUserInSession(user);
	}

	@Override
	public void onFailure(AuthenticationToken token, AuthenticationException ae) {

	}

	@Override
	public void onLogout(PrincipalCollection principals) {

	}

}
