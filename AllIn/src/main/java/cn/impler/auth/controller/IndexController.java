package cn.impler.auth.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.impler.auth.domain.Resource;
import cn.impler.auth.domain.User;
import cn.impler.auth.service.UserResourceRefedService;
import cn.impler.auth.util.SecurityUtil;

@Controller
@RequestMapping("/index")
public class IndexController {

	@Autowired
	private UserResourceRefedService urService;
	
	@RequestMapping
	public String toIndex(){
		User user = SecurityUtil.currentUser();
		Set<Resource> menus = urService.queryUserTopMenus(user);
		//TODO
		return null;
	}
}
