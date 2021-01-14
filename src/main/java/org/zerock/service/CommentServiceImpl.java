package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.CommentVO;
import org.zerock.mapper.CommentMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class CommentServiceImpl implements CommentService{
	
	private CommentMapper mapper;
	
	@Override
	public CommentVO get(int cno) {
		
		return mapper.read(cno);
	}
	@Override
	public List<CommentVO> getlist() {
		
		return mapper.getlist();
	}
	@Override
	public boolean modify(CommentVO reply) {
		
		return mapper.update(reply) == 1;
	}
	@Override
	public void register(CommentVO reply) {
		mapper.insertSelectKey(reply);
		
	}
	@Override
	public boolean remove(int cno) {
		
		return mapper.delete(cno) == 1;
	}
}
