package cn.impler.wechat.mrgfnr.dao.impl;

import org.springframework.stereotype.Component;

import cn.impler.framework.mybatis.dao.itf.AbstractDao;
import cn.impler.wechat.mrgfnr.dao.MrgFnrEventDao;
import cn.impler.wechat.mrgfnr.domain.MrgFnrEvent;

@Component("mrgFnrEventDao")
public class MrgFnrEventDaoImpl extends
		AbstractDao<MrgFnrEventDao, MrgFnrEvent, Integer> implements
		MrgFnrEventDao {

}
