package cn.impler.auth.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.impler.auth.domain.Resource;
import cn.impler.auth.domain.User;
import cn.impler.auth.domain.dto.FooKey;
import cn.impler.auth.service.UserResourceRefedService;
import cn.impler.auth.util.SecurityUtil;
import cn.impler.common.dto.Result;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/auth/index")
public class IndexController {

	@Autowired
	private UserResourceRefedService urService;
	
	/**
	 * goto dashboard
	 * @param model
	 * @return
	 */
	@RequestMapping
	public String toIndex(ModelMap model){
		User user = SecurityUtil.currentUser();
		Set<Resource> menus = urService.queryUserTopMenus(user);
		model.put("topMenus", menus);
		return "/auth/index";
	}
	
	/**
	 * show submenus
	 * @param parentId
	 * @param validateRt
	 */
	@RequestMapping("/{id}/subMenus")
	@ResponseBody
	public JSONObject showSubMenus(FooKey parentId, BindingResult validateRt){
		if(validateRt.hasErrors()){
			return Result.newResult(validateRt).toJson();
		}
		User user = SecurityUtil.currentUser();
		Set<Resource> menus = urService.queryUserSubMenus(parentId.getId(), user);
		return Result.newSuccessResult(menus).toJson();
	}
}
