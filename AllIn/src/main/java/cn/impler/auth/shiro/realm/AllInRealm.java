package cn.impler.auth.shiro.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import cn.impler.auth.domain.Resource;
import cn.impler.auth.domain.User;
import cn.impler.auth.service.UserResourceRefedService;
import cn.impler.auth.service.UserService;
import cn.impler.auth.shiro.Permission.RestfulPermission;
import cn.impler.auth.util.SecurityUtil;

public class AllInRealm extends AuthorizingRealm{

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserResourceRefedService userResRefedService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection collection) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		User user = SecurityUtil.currentUser();
		// query user referenced resources
		Set<Resource> res = userResRefedService.queryUserRefedResources(user.getId());
		// convert to permission
		Set<Permission> objectPermissions = convertToPermission(res);
		info.setObjectPermissions(objectPermissions);
		return info;
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

	/**
	 * convert resources to permissions
	 * @param res
	 * @return
	 */
	private Set<Permission> convertToPermission(Set<Resource> res) {
		if(null == res){
			return null;
		}
		
		Set<Permission> perms = new HashSet<Permission>();
		for(Resource r : res){
			perms.add(new RestfulPermission(r));
		}
		return perms;
	}
}
