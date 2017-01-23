package cn.impler.auth.controller;

import javax.validation.Valid;

import net.sf.json.JSONObject;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	//TODO spring bean validation does not support primary data type
	@RequestMapping(value="/permission", method=RequestMethod.POST)
	public JSONObject associatePermission(@Valid @NotEmpty Integer id, BindingResult idBdRt, 
												@Valid @NotEmpty String pIds, BindingResult pIdsBdRt){
		return null;
	}
	

	
	
}
