package cn.imper.allin.test.wechat.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.imper.allin.test.AbstractTest;
import cn.impler.framework.mybatis.dao.dto.Pagination;
import cn.impler.wechat.mrgfnr.dao.intf.MrgFnrEventDao;
import cn.impler.wechat.mrgfnr.domain.MrgFnrEvent;

public class TestMrgFnrEventDao extends AbstractTest {

	private MrgFnrEventDao mrgFnrEventDao;
	
	@Before
	public void before(){
		mrgFnrEventDao = (MrgFnrEventDao) super.context.getBean("mrgFnrEventDao");
	}
	
	@Test
	public void testQueryInPagination(){
		Pagination page = new Pagination();
		List<MrgFnrEvent> es = mrgFnrEventDao.queryInPagination(null, page );
		for(MrgFnrEvent e : es){
			System.out.println(e);
		}
	}

}
