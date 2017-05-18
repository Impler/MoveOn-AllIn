package cn.impler.auth.shiro.filter;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.web.filter.authz.HttpMethodPermissionFilter;
import org.springframework.beans.factory.annotation.Autowired;

import cn.impler.auth.domain.User;
import cn.impler.auth.service.ResourceService;
import cn.impler.auth.util.SecurityUtil;

public class DynamicPermissionsAuthorizationFilter extends HttpMethodPermissionFilter {

	@Autowired
	private ResourceService resService;
	
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
        
        //TODO
        // add current request resource into those permissions that waiting for verification
        String[] dynamicPerms = (String[]) ArrayUtils.add(perms, null);
        
        return super.isAccessAllowed(request, response, dynamicPerms);
	}
	
	
}
