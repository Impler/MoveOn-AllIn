package cn.impler.auth.shiro.Permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;

public class RestfulPermissionResolver implements PermissionResolver {

	@Override
	public Permission resolvePermission(String permissionString) {
		return new RestfulPermission(permissionString);
	}

}
