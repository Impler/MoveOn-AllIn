package cn.impler.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.impler.auth.domain.Permission;
import cn.impler.auth.domain.dto.PermissionSearchBean;
import cn.impler.auth.service.AuthService;
import cn.impler.auth.service.PermissionService;

@Controller
@RequestMapping("/auth/permission")
public class PermissionController extends AbsAuthController<Permission, PermissionSearchBean>{

	@Autowired
	private PermissionService permissionService;

	@Override
	public AuthService<Permission, PermissionSearchBean> getAuthService() {
		return permissionService;
	}
	
}
