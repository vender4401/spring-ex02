package org.zerock.mapper;

import static org.junit.Assert.*;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.CommentVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CommentMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private CommentMapper mapper;
	
	@Test
	public void testExist() {
		assertNotNull(mapper);
	}
	
	@Test
	public void testGetlist() {
		List<CommentVO> list = mapper.getlist();
		
		assertNotEquals(list.size(), 0);
	}
	
	@Test
	public void testInsert() {
		CommentVO comment = new CommentVO();
		comment.setBno(mapper.getlist().size() + 1);
		comment.setContent("첫 댓글");
		comment.setWriter("yoonkwan");
		
		mapper.insert(comment);				
	}
	
	
	@Test
	public void testInsertSelectKey() {
		CommentVO comment = new CommentVO();
		comment.setBno(mapper.getlist().size() + 1);
		comment.setContent("새로운 내용2");
		comment.setWriter("newbie2");
		
		mapper.insertSelectKey(comment);
	}
	
	@Test
	public void testRead() {
		CommentVO comment = new CommentVO();
		comment.setBno(5);
		comment.setContent("첫 댓글");
		comment.setWriter("yoonkwan");
				
		mapper.insertSelectKey(comment);
		
//		log.info(board);
		CommentVO readComment = mapper.read(comment.getCno());
		assertNotNull(readComment);
		assertEquals(readComment.getCno(), comment.getCno());
	}
	
	@Test
	public void testDelete() {
		CommentVO comment = new CommentVO();
		comment.setBno(mapper.getlist().size() + 1);
		comment.setContent("새로운 내용2");
		comment.setWriter("newbie2");
		
		mapper.insertSelectKey(comment);
			
		int before = mapper.getlist().size();
		
		int cnt = mapper.delete(comment.getCno());
		
		int after = mapper.getlist().size();
		
		assertEquals(cnt, 1);
		assertEquals(before - 1 , after);
	}
	
	@Test
	public void testUpdate() {
		CommentVO comment = new CommentVO();
		comment.setBno(mapper.getlist().size() + 1);
		comment.setContent("새로운 내용");
		comment.setWriter("newbie");
				
		mapper.insertSelectKey(comment);
		
		comment.setBno(comment.getBno());
		comment.setContent("변경된 내용");
		comment.setWriter("새로운 작성자");
		mapper.update(comment);
		
		int cnt = mapper.update(comment);
		assertEquals(1, cnt);
		
		CommentVO updateVO = mapper.read(comment.getCno());

		assertEquals("변경된 내용", updateVO.getContent());
		assertEquals("새로운 작성자", updateVO.getWriter());		
	}
}
