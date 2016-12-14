package cn.impler.wechat.mrgfnr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.impler.framework.mybatis.dao.dto.Pagination;
import cn.impler.wechat.mrgfnr.domain.MrgFnrEvent;
import cn.impler.wechat.mrgfnr.dto.MrgFnrEventSearchBean;
import cn.impler.wechat.mrgfnr.dto.Result;
import cn.impler.wechat.mrgfnr.service.intf.MrgFnrEventService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/wechat/mrgfnr")
public class MrgFnrController {

	@Autowired
	private MrgFnrEventService mfeService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public JSONObject query(MrgFnrEventSearchBean search, Pagination page){
		if(page.equals(Pagination.DEFAULT)){
			page.setPageSize(10);
		}
		List<MrgFnrEvent> es = mfeService.selectInPagination(search, page);
		JSONArray esArray = JSONArray.fromObject(es);
		return Result.newSuccessResult(esArray).toJson();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public JSONObject add(MrgFnrEvent event){
		mfeService.add(event);
		return Result.newSuccessResult().toJson();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public JSONObject delete(@PathVariable("id") int id){
		mfeService.delete(id);
		return Result.newSuccessResult().toJson();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public JSONObject update(MrgFnrEvent event){
		mfeService.update(event);
		return Result.newSuccessResult().toJson();
	}
	
	
	
}
