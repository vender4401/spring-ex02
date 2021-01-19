package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {
	
	public void register(BoardVO board);
	
//	public List<BoardVO> getlist();
	
	public List<BoardVO> getlist(Criteria cri);
	
	public BoardVO get(Long bno);
	
	public boolean remove (Long bno);
	
	public boolean modify (BoardVO board);
}
