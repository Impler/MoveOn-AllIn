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
        
        checkRequestUrlValid((HttpServletRequest) request);
        
        // add current request uri into those permissions that waiting for verification
        String[] dynamicPerms = (String[]) ArrayUtils.add(perms, requestURI);
        
        // 根据用户名查询分配的权限
        // 遍历权限，动态url 还是
        // 如果没有，遍历动态参数
        return super.isAccessAllowed(request, response, dynamicPerms);
	}
	
	
	private void checkRequestUrlValid(HttpServletRequest request){
		
		String requestURI = super.getPathWithinApplication(request);
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getSession().getAttribute(Constants.KEY_USER_IN_SESSION);
		Integer resourceId = resService.queryUserResourceIdByUrl(user, requestURI);
	}
}
