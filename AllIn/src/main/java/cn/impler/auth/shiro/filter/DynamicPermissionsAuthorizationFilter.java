package cn.impler.auth.shiro.filter;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

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
		
		if(user.isAdmin()){
			return true;
		}
		
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
		User user = (User) SecurityUtil.currentUser();
		return resService.queryUserResourceIdByUrl(user, requestURI);
	}
}
