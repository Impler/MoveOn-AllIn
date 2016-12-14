package cn.impler.wechat.mrgfnr.dao.intf;

import java.util.List;

import cn.impler.framework.mybatis.dao.dto.Pagination;
import cn.impler.framework.mybatis.dao.intf.BaseDao;
import cn.impler.wechat.mrgfnr.domain.MrgFnrEvent;
import cn.impler.wechat.mrgfnr.dto.MrgFnrEventSearchBean;

public interface MrgFnrEventDao extends BaseDao<MrgFnrEvent, Integer> {

	List<MrgFnrEvent> queryInPagination(MrgFnrEventSearchBean search, Pagination page);

}
