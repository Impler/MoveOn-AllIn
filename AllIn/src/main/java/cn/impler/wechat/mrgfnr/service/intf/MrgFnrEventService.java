package cn.impler.wechat.mrgfnr.service.intf;

import java.util.List;

import cn.impler.framework.mybatis.dao.dto.Pagination;
import cn.impler.wechat.mrgfnr.domain.MrgFnrEvent;
import cn.impler.wechat.mrgfnr.dto.MrgFnrEventSearchBean;

public interface MrgFnrEventService {

	/**
	 * 
	 * @param event
	 * @return
	 */
	int add(MrgFnrEvent event);

	/**
	 * @param search
	 * @param page
	 * @return
	 */
	List<MrgFnrEvent> selectInPagination(MrgFnrEventSearchBean search, Pagination page);

	/**
	 * 
	 * @param id
	 * @return
	 */
	int delete(int id);

	/**
	 * 
	 * @param event
	 * @return
	 */
	int update(MrgFnrEvent event);


	
}
