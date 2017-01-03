package cn.impler.wechat.mrgfnr.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.impler.framework.mybatis.dao.dto.Pagination;
import cn.impler.framework.mybatis.dao.intf.AbstractDao;
import cn.impler.framework.mybatis.dao.plugin.PaginationUtil;
import cn.impler.wechat.mrgfnr.dao.intf.MrgFnrEventDao;
import cn.impler.wechat.mrgfnr.domain.MrgFnrEvent;
import cn.impler.wechat.mrgfnr.domain.MrgFnrEventSearchBean;

@Component("mrgFnrEventDao")
public class MrgFnrEventDaoImpl extends
		AbstractDao<MrgFnrEventDao, MrgFnrEvent, Integer> implements
		MrgFnrEventDao {

	@Override
	public List<MrgFnrEvent> queryInPagination(MrgFnrEventSearchBean search,
			Pagination page) {
		return PaginationUtil.selectByPagination(super.getSqlSession(),
				"queryInPagination", "count", search, page);
	}

}
