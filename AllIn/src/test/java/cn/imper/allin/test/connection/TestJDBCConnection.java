package cn.imper.allin.test.connection;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.imper.allin.test.AbstractTest;

public class TestJDBCConnection extends AbstractTest{
	
	@Test
	public void test() throws SQLException {

		SqlSession sqlSession = (SqlSession) context.getBean("sqlSession");

		int count = sqlSession.selectOne("test.test");
		
		System.out.println("TEST SELECT: " + count);
	}
	
}
