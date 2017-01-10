package cn.impler.auth.controller;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.impler.auth.service.AuthService;
import cn.impler.framework.mybatis.dao.dto.Pagination;
import cn.impler.wechat.mrgfnr.dto.Result;

public abstract class AbsAuthController<E, S> {

	public abstract AuthService<E, S> getAuthService();
	
	/**
	 * query in pagination 
	 * @param search query key words
	 * @param page pagination information
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public JSONObject query(S search, Pagination page){
		List<E> rs = getAuthService().selectInPagination(search, page);
		JSONArray esArray = JSONArray.fromObject(rs);
		return Result.newSuccessResult(esArray, page).toJson();
	}
	
	/**
	 * create a role
	 * @param role
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String add(E e){
		getAuthService().add(e);
		return "";
	}
}
