package cn.imper.allin.connection;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJDBCConnection {
	private ClassPathXmlApplicationContext context = null;

	@Before
	public void before() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@After
	public void after(){
		context.close();
	}
	
	@Test
	public void test() throws SQLException {

		SqlSession sqlSession = (SqlSession) context.getBean("sqlSession");

		System.out.println("TEST JDBC CONNECTION:" + sqlSession.getConnection().isClosed());
	}
	
}
