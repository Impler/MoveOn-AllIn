package cn.impler.allin.auth.dao.impl;

import java.util.UUID;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.impler.auth.dao.UserDao;
import cn.impler.auth.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
//ApplicationContext configuration
@ContextConfiguration("/applicationContext.xml")
public class UserDaoTest {

	@Autowired
	private UserDao userDao;
	
	@Test
	public void testInsert() {
		User user = new User();
		user.setUsername("admin");
		user.setNickname("administrator");
		String salt = UUID.randomUUID().toString().replaceAll("-", "");
		user.setSalt(salt);
		SimpleHash hash = new SimpleHash("md5", "qwe123", salt);
		user.setPassword(hash.toString());
		user.setMobileNum("18761876537");
		user.setEmailAddress("test@qq.com");
		userDao.insert(user);
	}
}
