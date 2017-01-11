package cn.impler.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.impler.auth.domain.Role;
import cn.impler.auth.domain.dto.RoleSearchBean;
import cn.impler.auth.service.AuthService;
import cn.impler.auth.service.RoleService;

@Controller
@RequestMapping("/auth/role")
public class RoleController 
		extends AbsAuthController<Role, Integer, RoleSearchBean>{

	@Autowired
	private RoleService roleService;

	@Override
	public AuthService<Role, Integer, RoleSearchBean> getAuthService() {
		return roleService;
	}
	

	
	
}
