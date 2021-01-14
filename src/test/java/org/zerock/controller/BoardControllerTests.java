package org.zerock.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		{"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
			"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class BoardControllerTests {
	
	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext ctx;
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	private MockMvc mockMvc;

	
	@Before // 다른 메소드 이전에 실행됨
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testExist() {
		assertNotNull(ctx);
		assertNotNull(mockMvc);
	}
	
	@Test
	public void testList() throws Exception {
//		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/board/list"));
//		MvcResult rs = result.andReturn();
//		ModelAndView mv = rs.getModelAndView();
//		log.info(mv.getView());
//		log.info(mv.getModel().get("list"));
		
		Object o = mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
		.andReturn().getModelAndView().getModel().get("list");
		
		assertNotNull(o);
		assertTrue(o instanceof List);
		assertNotEquals(((List) o).size(), 0);
	}
	
	@Test
	public void testRegister() throws Exception {
		int before = mapper.getlist().size();
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
		.param("title", "테스트 새글 제목")
		.param("content", "테스트 새글 내용")
		.param("writer", "yoonkwan"))
		.andReturn();
		
		ModelAndView mv = result.getModelAndView();
		FlashMap map = result.getFlashMap();
		
		int after = mapper.getlist().size();
		
		assertEquals(before + 1, after);
		assertEquals("redirect:/board/list", mv.getViewName());
		assertNotNull(map.get("result"));
		
		log.info(map.get("result") + "**************************");
	}
	
}
