package cn.impler.wechat.mrgfnr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.impler.framework.mybatis.dao.dto.Pagination;
import cn.impler.wechat.mrgfnr.dao.intf.MrgFnrEventDao;
import cn.impler.wechat.mrgfnr.domain.MrgFnrEvent;
import cn.impler.wechat.mrgfnr.dto.MrgFnrEventSearchBean;
import cn.impler.wechat.mrgfnr.service.intf.MrgFnrEventService;

@Service("mrgFnrEventService")
public class MrgFnrEventServiceImpl implements MrgFnrEventService {

	@Autowired
	private MrgFnrEventDao mfeDao;
	
	@Override
	public int add(MrgFnrEvent event) {
		return mfeDao.insert(event);
	}

	@Override
	public List<MrgFnrEvent> selectInPagination(MrgFnrEventSearchBean search,
			Pagination page) {
		return mfeDao.queryInPagination(search, page);
	}

	@Override
	public int delete(int id) {
		return mfeDao.delete(id);
	}

	@Override
	public int update(MrgFnrEvent event) {
		return mfeDao.update(event);
	}

	@Override
	public MrgFnrEvent selectById(int id) {
		return mfeDao.selectOneByKey(id);
	}

}
