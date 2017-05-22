package cn.impler.auth.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.AntPathMatcher;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.impler.auth.domain.Resource;
import cn.impler.auth.domain.User;
import cn.impler.auth.domain.dto.FooKey;
import cn.impler.auth.service.UserResourceRefedService;
import cn.impler.auth.util.SecurityUtil;

@Controller
@RequestMapping("/auth/index")
public class IndexController {

	@Autowired
	private UserResourceRefedService urService;
	
	/**
	 * TODO use ajax?
	 * @param model
	 * @return
	 */
	@RequestMapping
	public String toIndex(ModelMap model){
		User user = SecurityUtil.currentUser();
		Set<Resource> menus = urService.queryUserTopMenus(user);
		model.put("menus", menus);
		return null;
	}
	
	@RequestMapping("/{id}/subMenu")
	public void showSubMenus(FooKey id, BindingResult validateRt){
		if(validateRt.hasErrors()){
			//TODO
			return ;
		}
		User user = SecurityUtil.currentUser();
		Set<Resource> menus = urService.queryUserSubMenus(id.getId(), user);
	}
	
	public static void main(String[] args) {
		
		AntPathMatcher ant = new AntPathMatcher();
	
		System.out.println(ant.extractPathWithinPattern("/a/b/{id}/c", "aaa"));
		System.out.println(ant.extractUriTemplateVariables("/a/b/{id}/c", "/a/b/aaaaa/c"));
	}
}
