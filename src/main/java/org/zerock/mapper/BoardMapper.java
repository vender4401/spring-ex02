package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {

//	@Select("SELECT * FROM tbl_board WHERE bno > 0")
	public List<BoardVO> getlist();
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
//		1.seq.board의 nextval을 먼저 조회(select)
//		2.조회된 
}
