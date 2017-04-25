package cn.impler.auth.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import cn.impler.auth.domain.User;
import cn.impler.auth.service.UserService;
import cn.impler.auth.util.SecurityUtil;

public class AllInFormAuthenticationFilter extends FormAuthenticationFilter {

	@Autowired
	private UserService userService;
	
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token,
			Subject subject, ServletRequest request, ServletResponse response)
			throws Exception {
		
		String username = (String) subject.getPrincipal();
		User user = userService.queryCommonInfoByUsername(username);
		Assert.notNull(user);
		SecurityUtil.keepUserInSession(user);
		
		return super.onLoginSuccess(token, subject, request, response);
	}

	
}
