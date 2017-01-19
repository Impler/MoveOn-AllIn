package cn.impler.auth.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.impler.auth.dto.OperateType;
import cn.impler.auth.service.AuthService;
import cn.impler.framework.mybatis.dao.dto.Pagination;
import cn.impler.wechat.mrgfnr.dto.Result;

/**
 * 
 * @author impler
 * @date 2017-01-12
 * @param <E> entity class
 * @param <K> entity id
 * @param <S> entity search key word
 */
public abstract class AbsAuthController<E, K, S> {

	/**
	 * abstract function, which depends on sub-class' implement
	 * and return the actual AuthService implements
	 * @return
	 */
	public abstract AuthService<E, K, S> getAuthService();
	
	protected Map<OperateType, String> resultMappings = getResultMappings();
	
	protected Map<OperateType, String> getResultMappings(){
		Map<OperateType, String> resultMapping = new HashMap<OperateType, String>();
		resultMapping.put(OperateType.ADD, "add");
		resultMapping.put(OperateType.DELETE, "delete");
		resultMapping.put(OperateType.UPDATE, "update");
		resultMapping.put(OperateType.QUERY, "query");
		return resultMapping;
	}
	
	/**
	 * query in pagination 
	 * @param search query key words
	 * @param page pagination information
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public JSONObject query(S search, Pagination page){
		List<E> rs = this.getAuthService().selectInPagination(search, page);
		JSONArray esArray = JSONArray.fromObject(rs);
		return Result.newSuccessResult(esArray, page).toJson();
	}
	
	/**
	 * create a entity
	 * @param entity
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String add(@Valid E e, BindingResult validateRt){
		this.getAuthService().add(e);
		return resultMappings.get(OperateType.ADD);
	}
	
	/**
	 * delete a entity by id
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public JSONObject deleteById(@PathVariable K id){
		this.getAuthService().deleteById(id);
		return Result.newSuccessResult().toJson();
	}
	
	/**
	 * update a entity
	 * @param e
	 * @return
	 */
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public JSONObject update(E e){
		this.getAuthService().update(e);
		return Result.newSuccessResult().toJson();
	}
}
