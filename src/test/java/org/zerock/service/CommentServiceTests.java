package org.zerock.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.CommentVO;

import org.zerock.mapper.CommentMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CommentServiceTests {

//	@Setter(onMethod_ = @Autowired)
	private CommentService service;
	
	@Autowired
	@Qualifier("commentServiceImpl")
	public void setService(CommentService service) {
		this.service = service;
	}
	
	@Setter(onMethod_ =@Autowired)
	private CommentMapper mapper;	
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		CommentVO comment = new CommentVO();
		comment.setBno(mapper.getlist().size() + 1);
		comment.setContent("새로운 내용");
		comment.setWriter("yoonkwan");
		
		int before = mapper.getlist().size();
		
		service.register(comment);
		
		int after = mapper.getlist().size();
		
		assertEquals(before + 1, after);		
	}
	
	@Test
	public void testGetlist() {
		List<CommentVO> list = service.getlist();
		
		assertNotNull(list);
		assertNotEquals(list.size(), 0);
	}
	
	
	@Test
	public void testGet() {
		CommentVO comment = new CommentVO();
		comment.setBno(mapper.getlist().size() + 1);
		comment.setContent("새로운 내용");
		comment.setWriter("yoonkwan");
		
		service.register(comment);

		CommentVO vo = service.get(comment.getCno());
		
		assertNotNull(vo);
		assertEquals(vo.getCno(), comment.getCno());
		assertEquals(vo.getContent(), comment.getContent());
	}
	
	@Test
	public void testDelete() {
		CommentVO comment = new CommentVO();
		comment.setBno(mapper.getlist().size() + 1);
		comment.setContent("새로운 내용");
		comment.setWriter("yoonkwan");
		
		service.register(comment);
				
		assertTrue(service.remove(comment.getCno()));
	}
	
	@Test
	public void testUpdate() {
		CommentVO comment = new CommentVO();
		comment.setBno(mapper.getlist().size() + 1);
		comment.setContent("새로운 내용");
		comment.setWriter("yoonkwan");
		
		service.register(comment);
		
		CommentVO up = new CommentVO();
		up.setCno(comment.getCno());
		up.setBno(comment.getBno());
		up.setContent("수정된 내용");
		up.setWriter("newbie");
		
		assertTrue(service.modify(up));
		
		CommentVO up2 = service.get(comment.getCno());
		
		assertEquals(up.getBno(), up2.getBno());
		assertEquals(up.getContent(), up2.getContent());		
	}

}
