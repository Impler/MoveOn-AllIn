package cn.imper.allin.test.wechat.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.imper.allin.test.AbstractTest;
import cn.impler.wechat.mrgfnr.dao.MrgFnrEventDao;
import cn.impler.wechat.mrgfnr.domain.MrgFnrEvent;

public class TestMrgFnrEventDao extends AbstractTest {

	private MrgFnrEventDao mrgFnrEventDao;
	
	@Before
	public void before(){
		mrgFnrEventDao = (MrgFnrEventDao) super.context.getBean("mrgFnrEventDao");
	}
	
	@Test
	public void testSelect(){
		List<MrgFnrEvent> es = mrgFnrEventDao.select();
		for(MrgFnrEvent e : es){
			System.out.println(e);
		}
	}

}
