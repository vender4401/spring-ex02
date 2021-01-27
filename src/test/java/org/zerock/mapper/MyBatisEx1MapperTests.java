package org.zerock.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.Ex1Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MyBatisEx1MapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private MyBatisEx1Mapper mapper;
	
	@Test
	public void testExist() {
		assertNotNull(mapper);
	}
	
	
	@Test
	public void testSelect1() {
		Ex1Criteria cri = new Ex1Criteria();
		cri.setBno(0);
		
		mapper.select1(cri);
	}
	
	@Test
	public void testSelect1Ex1() {
		Ex1Criteria cri = new Ex1Criteria();
		cri.setBno(1);
		
		mapper.select1(cri);
	}
//	----------------------------------- select2
	@Test
	public void testSelect2Ex1() {
		Ex1Criteria cri = new Ex1Criteria();
		cri.setType("title");
		cri.setKeyword("테스트");
		
		mapper.select2(cri);
	}
	
	@Test
	public void testSelect2Ex2() {
		Ex1Criteria cri = new Ex1Criteria();
		cri.setType("content");
		cri.setKeyword("테스트");
		
		mapper.select2(cri);
	}
	
	@Test
	public void testSelect2Ex3() {
		Ex1Criteria cri = new Ex1Criteria();
		cri.setType("writer");
		cri.setKeyword("yoonkwan");
		
		mapper.select2(cri);
	}
//	----------------------------------- select3
	@Test
	public void testSelect3Ex1() {
		Ex1Criteria cri = new Ex1Criteria();
		cri.setType("T");
		cri.setKeyword("테스트");
		
		mapper.select3(cri);
	}
	
	@Test
	public void testSelect3Ex2() {
		Ex1Criteria cri = new Ex1Criteria();
		cri.setType("C");
		cri.setKeyword("테스트");
		
		mapper.select3(cri);
	}
	
	@Test
	public void testSelect3Ex3() {
		Ex1Criteria cri = new Ex1Criteria();
		cri.setType("W");
		cri.setKeyword("yoonkwan");
		
		mapper.select3(cri);
	}
//	----------------------------------- select4
	
	@Test
	public void testSelect4Ex1() {
		Ex1Criteria cri = new Ex1Criteria();
		cri.setType("title");
		cri.setKeyword("테스트");
		
		mapper.select4(cri);
	}
	
	@Test
	public void testSelect4Ex2() {
		Ex1Criteria cri = new Ex1Criteria();
		cri.setType("content");
		cri.setKeyword("테스트");
		
		mapper.select4(cri);
	}
	
	@Test
	public void testSelect4Ex3() {
		Ex1Criteria cri = new Ex1Criteria();
		cri.setType("writer");
		cri.setKeyword("테스트");
		
		mapper.select4(cri);
	}
	
	@Test
	public void testSelect4Ex4() {
		Ex1Criteria cri = new Ex1Criteria();
		cri.setType("");
		cri.setKeyword("테스트");
		
		mapper.select4(cri);
	}
//	----------------------------------- select5
	
	@Test
	public void testSelect5Ex1() {
		Ex1Criteria cri = new Ex1Criteria();
		cri.setType("title");
		cri.setKeyword("테스트");
		
		mapper.select5(cri);
	}
	
	@Test
	public void testSelect5Ex2() {
		Ex1Criteria cri = new Ex1Criteria();
		cri.setType("content");
		cri.setKeyword("테스트");
		
		mapper.select5(cri);
	}
	
	@Test
	public void testSelect5Ex3() {
		Ex1Criteria cri = new Ex1Criteria();
		cri.setType("");
		cri.setKeyword("테스트");
		
		mapper.select5(cri);
	}
//	----------------------------------- select6
	@Test
	public void testSelect6Ex1() {
		List<String> list = new ArrayList<>();
		list.add("java");
		list.add("sql");
		list.add("spring");
		
		Ex1Criteria cri = new Ex1Criteria();
		cri.setMylist(list);
		
		mapper.select6(cri);
	}
	
//	----------------------------------- select7
	@Test
	public void testSelect7Ex1() {
		Map<String, String> map = new HashMap<>();
		map.put("java", "jsp");
		map.put("sql", "root");
		map.put("spring", "jango");
		
		Ex1Criteria cri = new Ex1Criteria();
		cri.setMymap(map);
		
		mapper.select7(cri);
	}
//	----------------------------------- select7
	@Test
	public void testSelect8Ex1() {
		List<String> list = new ArrayList<>();
		list.add("choi");
		list.add("yoon");
		list.add("kwan");
		
		Ex1Criteria cri = new Ex1Criteria();
		cri.setMylist(list);
		
		mapper.select8(cri);
	}
	
//	----------------------------------- select7
	@Test
	public void testSelect9Ex1() {
		List<String> list = new ArrayList<>();
		list.add("choi");
		list.add("yoon");
		list.add("kwan");
		
		Ex1Criteria cri = new Ex1Criteria();
		cri.setMylist(list);
		
		mapper.select9(cri);
	}
	
}
