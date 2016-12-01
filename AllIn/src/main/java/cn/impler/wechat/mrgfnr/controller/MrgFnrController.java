package cn.impler.wechat.mrgfnr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.impler.framework.mybatis.dao.dto.Pagination;
import cn.impler.wechat.mrgfnr.domain.MrgFnrEvent;
import cn.impler.wechat.mrgfnr.dto.MrgFnrEventSearchBean;
import cn.impler.wechat.mrgfnr.service.MrgFnrEventService;

@Controller
@RequestMapping("/wechat/mrgfnr")
public class MrgFnrController {

	@Autowired
	private MrgFnrEventService mfeService;
	
	@RequestMapping
	public void events(MrgFnrEventSearchBean search, Pagination page){
		List<MrgFnrEvent> es = mfeService.selectInPagination(search, page);
		System.out.println(es);
	}
	
	@RequestMapping("/event")
	public void add(MrgFnrEvent event){
		mfeService.add(event);
	}
	
	
}
