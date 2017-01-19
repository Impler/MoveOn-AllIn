package cn.impler.wechat.mrgfnr.controller;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.impler.common.dto.Result;
import cn.impler.framework.mybatis.dao.dto.Pagination;
import cn.impler.wechat.mrgfnr.domain.MrgFnrEvent;
import cn.impler.wechat.mrgfnr.domain.MrgFnrEventSearchBean;
import cn.impler.wechat.mrgfnr.service.intf.MrgFnrEventService;

@Controller
@RequestMapping("/wechat/mrgfnr")
public class MrgFnrController {

	@Autowired
	private MrgFnrEventService mfeService;
	
	private static final JsonConfig MrgFnrBeanIgnore;
	
	static{
		MrgFnrBeanIgnore = new JsonConfig();
		MrgFnrBeanIgnore.setExcludes(new String[]{"type", "date", "createTime", "lastUpdateTime"});
	}
	/**
	 * query marriage and funeral events by pagination
	 * @param search
	 * @param page
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public JSONObject query(MrgFnrEventSearchBean search, Pagination page){
		List<MrgFnrEvent> es = mfeService.selectInPagination(search, page);
		JSONArray esArray = JSONArray.fromObject(es, MrgFnrBeanIgnore);
		return Result.newSuccessResult(esArray).toJson();
	}
	
	/**
	 * add a marriage or funeral event
	 * @param event
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String add(MrgFnrEvent event){
		mfeService.add(event);
		return "wechat/mrgfnr/list";
	}
	
	/**
	 * delete a marriage or funeral event
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public JSONObject delete(@PathVariable("id") int id){
		mfeService.delete(id);
		return Result.newSuccessResult().toJson();
	}
	
	/**
	 * query a marriage or funeral event by id
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject selectOne(@PathVariable int id){
		MrgFnrEvent event = mfeService.selectById(id);
		return Result.newSuccessResult(event).toJson();
	}
	
	/**
	 * update a marriage or funeral event information
	 * @param event
	 * @return
	 */
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public String update(MrgFnrEvent event){
		mfeService.update(event);
		return "redirect:detail/" + event.getId() + ".do";
	}
	
	/**
	 * route to event detail page
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/detail/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable int id){
		return "wechat/mrgfnr/new";
	}
	
}
