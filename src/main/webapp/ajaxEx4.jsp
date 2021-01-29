<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
  src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
  src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>

<title>Insert title here</title>
<script>
$(document).ready(function() {
	$("#btn-1").click(function() {
		$.ajax({
			type: "post",
			url: "/replies/new",
			contentType: "application/json",
			data: '{"bno":326, "reply":"새 댓글~", "replyer":"yoonkwan"}',
			complete: function(jqXHR, status) {
				console.log("data에 입력된 bno 번호로 댓글 등록 성공");
				console.log(status);
			}
		})
	})
	
	$("#btn-2").click(function() {
		$.ajax({
			type: "post",
			url: "/replies/new",
			contentType: "application/json",
			data: '{"bno":, "reply":"", "replyer":"yoonkwan"}', 
			//bno값과 reply값을 넣지 않음 // 데이터베이스에 NOT NULL로 테이블 생성했기에 에러가 출력됨
			complete: function(jqXHR, status) {
				console.log("data에 입력된 bno 번호로 댓글 등록 성공");
				console.log(status);
			}
		})
	})
	
	$("#btn-3").click(function() {
		$.ajax({
			type: "post",
			url: "/replies/new",
			contentType: "application/json",
			data: '{"bno":249, "reply":"ㅁㅁ", "replyer":"yoonkwan"}',
		}).done(function(data, status, xhr) {
			console.log("등록 성공")
			//console.log(jqXHR.responseText);
			console.log(data);			
			console.log(xhr);			
		}).fail(function() {
			console.log("등록 실패");
		});
	})
	
	$("#btn-4").click(function() {
		$.ajax({
			type: "GET",
			url: "/replies/pages/326/1",
		}).done(function(data, status, xhr) {
			console.log("등록 성공")
			//console.log(jqXHR.responseText);
			console.log(data);			
			console.log(xhr);			
		}).fail(function() {
			console.log("등록 실패");
		});
	})
	
	$("#btn-5").click(function() {
		$.ajax({
			type: "PUT",
			url: "/replies/46",
			contentType: "application/json",
			data: '{"reply":"json수정 122"}',		
		}).done(function(data, status, xhr) {
			console.log("수정 성공")
			//console.log(jqXHR.responseText);
			console.log(data);			
			console.log(xhr);			
		}).fail(function() {
			console.log("수정 실패");
		});
	})
	
	$("#btn-6").click(function() {
		$.ajax({
			type: "DELETE",
			url: "/replies/44",
		}).done(function(data, status, xhr) {
			console.log("삭제 성공")
			//console.log(jqXHR.responseText);
			console.log(data);			
			console.log(xhr);			
		}).fail(function() {
			console.log("삭제 실패");
		});
	})	
})

</script>
</head>
<body>
<h1>AJAX ex4</h1>

<div>
<button id="btn-1">댓글 등록 성공 버튼</button>
</div>

<div>
<button id="btn-2">댓글 등록 실패 버튼</button>
</div>

<div>
<button id="btn-3">댓글 등록 실패 성공 또는 실패</button>
</div>

<div>
<button id="btn-4">댓글 목록 보기</button>
</div>

<div>
<button id="btn-5">댓글 수정</button>
</div>

<div>
<button id="btn-6">댓글 삭제</button>
</div>

</body>
</html>