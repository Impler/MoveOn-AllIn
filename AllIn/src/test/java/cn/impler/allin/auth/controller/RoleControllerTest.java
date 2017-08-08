package cn.impler.allin.auth.controller;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import cn.impler.allin.base.WebTestBase;

public class RoleControllerTest extends WebTestBase{

	@Test
	public void testQuery() throws Exception {
		MvcResult rs = super.mockMvc
				.perform(MockMvcRequestBuilders.get("/auth/role.do")
						.accept(MediaType.parseMediaType("application/json")))
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
		
		System.out.println(rs);
	}

	@Test
	public void testAdd() throws Exception {
		MvcResult rs = super.mockMvc
				.perform(MockMvcRequestBuilders.post("/auth/role.do")
						.accept(MediaType.parseMediaType("application/json"))
						.param("name", "管理员角色")
						.param("description", "管理员角色"))
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
		System.out.println(rs);
	}

	@Test
	public void testDeleteById() throws Exception {
		// no id 
		MvcResult rs = super.mockMvc
				.perform(MockMvcRequestBuilders.delete("/auth/role/.do")
						.accept(MediaType.parseMediaType("application/json")))
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
		System.out.println(rs);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}
}
