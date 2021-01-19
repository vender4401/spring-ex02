package org.zerock.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.BoardMapperTests;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@Setter(onMethod_ =@Autowired)
	private BoardMapper mapper;	
	
	@Test
	public void testExist() {
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("새로운 글");
		board.setContent("새로운 내용");
		board.setWriter("yoonkwan");
		
		int before = mapper.getlist().size();
		
		service.register(board);
		
		int after = mapper.getlist().size();
		
		assertEquals(before + 1, after);		
	}
	
	@Test
	public void testGetlist() {
//		List<BoardVO> list = service.getlist();
		
		Criteria cri = new Criteria(2, 10);
		List<BoardVO> list = service.getlist(cri);
		
		assertNotNull(list);
		assertNotEquals(list.size(), 0);
		assertEquals(list.size(), 10);
	}
	
	
	@Test
	public void testGet() {
		BoardVO board = new BoardVO();
		board.setTitle("새로운 글");
		board.setContent("새로운 내용");
		board.setWriter("yoonkwan");
		
		service.register(board);

		BoardVO vo = service.get(board.getBno());
		
		assertNotNull(vo);
		assertEquals(vo.getBno(), board.getBno());
	}
	
	@Test
	public void testDelete() {
		BoardVO board = new BoardVO();
		board.setTitle("새로운 글");
		board.setContent("새로운 내용");
		board.setWriter("yoonkwan");
		
		service.register(board);
				
		assertTrue(service.remove(board.getBno()));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setTitle("새로운 글");
		board.setContent("새로운 내용");
		board.setWriter("yoonkwan");
		
		service.register(board);
		
		BoardVO up = new BoardVO();
		up.setBno(board.getBno());
		up.setTitle("수정된 제목");
		up.setContent("수정된 내용");
		up.setWriter("newbie");
		
		assertTrue(service.modify(up));
		
		BoardVO up2 = service.get(board.getBno());
		
//		assertEquals("수정된 제목", up2.getTitle());
//		assertEquals("수정된 내용", up2.getContent());
		assertEquals(up.getTitle(), up2.getTitle());
		assertEquals(up.getContent(), up2.getContent());		
	}

}
