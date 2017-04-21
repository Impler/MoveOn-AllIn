package cn.impler.auth.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import cn.impler.auth.domain.User;
import cn.impler.auth.service.UserService;

public class AllInRealm extends AuthorizingRealm{

	@Autowired
	private UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection collection) {
		
		String username = (String) collection.getPrimaryPrincipal();
		User user = userService.queryCommonInfoByUsername(username);
//		List<Integer> roleIds = userService.queryRefedRoleIds(user.getId());
		//TODO
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String userName = upToken.getUsername().trim();
		// query user security info: hashed password, salt value by username
		User user = userService.querySecurityInfoByUsername(userName);
		
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName,
				user.getPassword(), ByteSource.Util.bytes(user.getSalt().getBytes()), super.getName());
		
		return info;
	}

}
