package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.CommentVO;

public interface CommentMapper {
	
	public List<CommentVO> getlist();
	
	public void insert(CommentVO comment);
	
	public void insertSelectKey(CommentVO comment);
	
	public CommentVO read (int cno);
	
	public int delete (int cno);
	
	public int update (CommentVO comment);
}
