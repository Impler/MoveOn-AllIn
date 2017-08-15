package cn.impler.auth.shiro.permission;

import java.io.Serializable;

import org.apache.shiro.authz.Permission;
import org.springframework.util.AntPathMatcher;

public class RestfulPermission implements Permission, Serializable {

	private static final long serialVersionUID = 5695137306899909695L;

	private final String permissionString;

	public RestfulPermission(String permissionString) {
		super();
		this.permissionString = permissionString;
	}

	public String getPermissionString() {
		return permissionString;
	}

	@Override
	public boolean implies(Permission p) {
		if (null == p) {
			return false;
		}
		if (!(p instanceof RestfulPermission)) {
			return false;
		}
		RestfulPermission rtf = (RestfulPermission) p;

		AntPathMatcher matcher = new AntPathMatcher();
		return matcher.match(this.permissionString, rtf.getPermissionString());
	}

}
