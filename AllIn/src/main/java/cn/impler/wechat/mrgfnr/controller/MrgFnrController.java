package cn.impler.wechat.mrgfnr.controller;

import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.impler.framework.mybatis.dao.dto.Pagination;
import cn.impler.wechat.mrgfnr.domain.MrgFnrEvent;
import cn.impler.wechat.mrgfnr.dto.MrgFnrEventSearchBean;
import cn.impler.wechat.mrgfnr.service.MrgFnrEventService;

@Controller
@RequestMapping("/wechat/mrgfnr")
public class MrgFnrController {

	@Autowired
	private MrgFnrEventService mfeService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public JSONArray query(MrgFnrEventSearchBean search, Pagination page){
		if(page.equals(Pagination.DEFAULT)){
			page.setPageSize(10);
		}
		List<MrgFnrEvent> es = mfeService.selectInPagination(search, page);
		JSONArray esArray = JSONArray.fromObject(es);
		return esArray;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void add(MrgFnrEvent event){
		int result = mfeService.add(event);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id){
		int result = mfeService.delete(id);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public void update(MrgFnrEvent event){
		int result = mfeService.update(event);
	}
	
	
	
}
