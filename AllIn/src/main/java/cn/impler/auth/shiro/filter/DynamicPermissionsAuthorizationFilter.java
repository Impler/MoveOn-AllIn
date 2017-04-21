package cn.impler.auth.shiro.filter;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.HttpMethodPermissionFilter;
import org.springframework.beans.factory.annotation.Autowired;

import cn.impler.auth.common.Constants;
import cn.impler.auth.domain.User;
import cn.impler.auth.service.ResourceService;

public class DynamicPermissionsAuthorizationFilter extends HttpMethodPermissionFilter {

	@Autowired
	private ResourceService resService;
	
	@Override
	public boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws IOException {
		
        String[] perms = (String[]) mappedValue;
        
        if(super.isLoginRequest(request, response)){
        	return true;
        }
        
        Integer resId = checkRequestUrlValid((HttpServletRequest) request);
        // no resource matched, return false
        if(null == resId){
        	return false;
        }
        
        // add current request resource into those permissions that waiting for verification
        String[] dynamicPerms = (String[]) ArrayUtils.add(perms, resId);
        
        return super.isAccessAllowed(request, response, dynamicPerms);
	}
	
	
	private Integer checkRequestUrlValid(HttpServletRequest request){
		String requestURI = super.getPathWithinApplication(request);
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getSession().getAttribute(Constants.KEY_USER_IN_SESSION);
		return resService.queryUserResourceIdByUrl(user, requestURI);
	}
}
