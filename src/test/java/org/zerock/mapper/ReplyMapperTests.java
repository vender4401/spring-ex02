package org.zerock.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	private Long[] bnoArr = {326L, 325L, 324L, 323L, 301L};
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Test
	public void testExist() {
		assertNotNull(mapper);				
	}
	
	@Test
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			log.info(i + "," + i % 5);	
			ReplyVO vo = new ReplyVO();
			vo.setBno(bnoArr[i % 5]);
			vo.setReply("댓글 테스트" + i);
			vo.setReplyer("replyer" + i);
			
			mapper.insert(vo);
		});
		//1부터 10까지의 Stream 의 값을 보내줌
	}	
	
	@Test
	public void testDelete() {
		
		mapper.delete(1L);
		
	}
	
	
	@Test
	public void testUpdate() {
		ReplyVO vo = new ReplyVO();
		vo.setRno(2L);
		vo.setReply("수정된 댓글2");
		mapper.update(vo);

	}
	
	@Test
	public void testCreate2() {
		ReplyVO vo = new ReplyVO();
		//vo.setRno(rno); // 자동으로 rno 값은 추가 (.xml 확인)
		vo.setBno(326L);	// tbl_board 테이블에 있는 값
		vo.setReply("댓글 테스트");
		vo.setReplyer("yoonkwan");
		
		
		mapper.insert(vo);		
		
		try {
			vo.setBno(9999999L);	// tbl_board 테이블에 없는 값
			mapper.insert(vo);	
			fail();
		} catch (Exception e) {
			
		}
	}		
	
	@Test
	public void testRead() {	
		ReplyVO vo = mapper.read(7L);
		log.info(vo);
	}
	
	@Test
	public void testGetList() {
		List<ReplyVO> list = mapper.getListWithPaging(null, 326L);
		assertNotEquals(0, list.size());		
	}
	
	
}
