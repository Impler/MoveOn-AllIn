package cn.impler.allin.base;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
//@WebAppConfiguration annotation should be used 
//in conjunction with @ContextConfiguration annotation
@WebAppConfiguration("/spring-servlet.xml")
public class WebTestBase {

	@Autowired
    private WebApplicationContext wac;
	
	protected MockMvc mockMvc;
	
	@Before
	public void before(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
}
