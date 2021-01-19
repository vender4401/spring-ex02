package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {

//	@Select("SELECT * FROM tbl_board WHERE bno > 0")
	public List<BoardVO> getlist();
	
	public List<BoardVO> getlistWithPaging(Criteria cri);
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	// 1. seq_board의 nextval을 먼저 조회(select)
	// 2. 조회된 nextval을 insert에서 사용
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
}
