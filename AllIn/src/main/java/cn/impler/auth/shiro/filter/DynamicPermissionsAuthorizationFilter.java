package cn.impler.auth.shiro.filter;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.web.filter.authz.HttpMethodPermissionFilter;

public class DynamicPermissionsAuthorizationFilter extends HttpMethodPermissionFilter {

	@Override
	public boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws IOException {
		
        String[] perms = (String[]) mappedValue;
        
        String requestURI = super.getPathWithinApplication(request);
        if(super.getLoginUrl().equals(requestURI)){
        	return true;
        }
        // add current request uri into those permissions that waiting for verification
        String[] dynamicPerms = (String[]) ArrayUtils.add(perms, requestURI);
        
        return super.isAccessAllowed(request, response, dynamicPerms);
	}
	
}
