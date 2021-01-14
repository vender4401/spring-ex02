package org.zerock.service;

import java.util.List;

import org.zerock.domain.CommentVO;

public interface CommentService {

	public void register(CommentVO reply);
	
	public List<CommentVO> getlist();
	
	public CommentVO get(int cno);
	
	public boolean remove (int cno);
	
	public boolean modify (CommentVO reply);
}
