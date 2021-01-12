package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	// 테이블의 칼럼 구조를 반영함.
	// 테이블에 해당하는 필드 생성.
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updatedate;	
}
