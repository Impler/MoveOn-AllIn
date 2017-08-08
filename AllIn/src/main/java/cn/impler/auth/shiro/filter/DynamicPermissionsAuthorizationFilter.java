package cn.impler.auth.shiro.filter;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.web.filter.authz.HttpMethodPermissionFilter;

import cn.impler.auth.domain.User;
import cn.impler.auth.util.SecurityUtil;

public class DynamicPermissionsAuthorizationFilter extends HttpMethodPermissionFilter {

	@Override
	public boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws IOException {
		User user = (User) SecurityUtil.currentUser();
		
		if(null != user && user.isAdmin()){
			return true;
		}
		
        String[] perms = (String[]) mappedValue;
        
        if(super.isLoginRequest(request, response)){
        	return true;
        }
        
        // add current request resource into those permissions that waiting for verification
        String currentUri = super.getPathWithinApplication(request);
        String[] dynamicPerms = (String[]) ArrayUtils.add(perms, currentUri);
        
        return super.isAccessAllowed(request, response, dynamicPerms);
	}

	/**
	 * TODO
	 * ajax request or common request should be treated differently
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws IOException {
		return super.onAccessDenied(request, response);
	}
	
}
