package cn.impler.allin.auth.dao.impl;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.impler.auth.dao.RoleDao;
import cn.impler.auth.domain.Role;
import cn.impler.framework.mybatis.dao.dto.Pagination;

@RunWith(SpringJUnit4ClassRunner.class)
//ApplicationContext configuration
@ContextConfiguration("/applicationContext.xml")
public class RoleDaoImplTest {

	@Autowired
	private RoleDao roleDao;
	
	@Test
	public void testSelectInPagination() {
		List<Role> roles = roleDao.selectInPagination(null, new Pagination());
		for(Role r : roles){
			System.out.println(r);
		}
	}

	@Test
	public void testInsert() {
		Role r = new Role();
		r.setName("超级管理员");
		r.setDescription("超级管理员角色");
		roleDao.insert(r);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelect() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectOneByKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByCondition() {
		fail("Not yet implemented");
	}
}
