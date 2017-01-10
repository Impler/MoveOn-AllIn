package cn.impler.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.impler.auth.domain.User;
import cn.impler.auth.domain.dto.UserSearchBean;
import cn.impler.auth.service.AuthService;
import cn.impler.auth.service.UserService;

@Controller
@RequestMapping("/auth/user")
public class UserController extends AbsAuthController<User, UserSearchBean>{

	@Autowired
	private UserService userService;

	@Override
	public AuthService<User, UserSearchBean> getAuthService() {
		return userService;
	}
	

}
