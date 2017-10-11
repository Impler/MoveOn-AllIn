package cn.impler.auth.shiro.listener;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationListener;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.subject.WebSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import cn.impler.auth.domain.LoginDetail;
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
		
		LoginDetail detail = collectionLoginDetailInfo(user, null);
        userService.saveLoginDetail(user, detail );
	}

	@Override
	public void onFailure(AuthenticationToken token, AuthenticationException ae) {
	    String username = (String) token.getPrincipal();
	    User user = userService.querySecurityInfoByUsername(username);
	    if(null == user){
	        user = new User();
	        user.setUsername(username);
	    }
	    
	    LoginDetail detail = collectionLoginDetailInfo(user, ae);
        userService.saveLoginDetail(user, detail );
	}

	@Override
	public void onLogout(PrincipalCollection principals) {
	    System.out.println("onLogout");
	}

	private LoginDetail collectionLoginDetailInfo(User user, AuthenticationException ae){
	    LoginDetail detail = new LoginDetail();
	    WebSubject subject = (WebSubject) SecurityUtils.getSubject();
	    ShiroHttpServletRequest request = (ShiroHttpServletRequest) subject.getServletRequest();
	    String ip = request.getRemoteHost();
	    detail.setIp(ip);
	    detail.setUsername(user.getUsername());
	    detail.setUserId(user.getId());
	    if(null != ae){
	        String failedMsg = ae.getClass().getSimpleName();
	        detail.setLoginException(failedMsg);
	        detail.setLoginStatus(LoginDetail.LOGIN_STATUS_FAILURE);
	    }else{
	        detail.setLoginStatus(LoginDetail.LOGIN_STATUS_SUCCESS);
	    }
	    return detail;
	}
}
