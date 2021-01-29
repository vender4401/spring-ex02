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
		$.get("/replies/96")
		.done(function(data) {
			console.log(data);
		})
	})	
	
	$("#btn-2").click(function() {
		$.get("/replies/96", function(data) {
			console.log(data);
		})
	})	
	
	// json
	$("#btn-3").click(function() {
		$.get("/replies/96", function(data) {
			console.log(data);
			console.log(data.rno);
			console.log(data.bno);
			console.log(data.reply);			
			console.log(data.replyer);			
		}, "json");
	})	
	
	// 텍스트 
	$("#btn-4").click(function() {
		$.get("/replies/96", function(data) {
			console.log(data);
			console.log(data.bno);
			console.log(data.reply);			
			console.log(data.replyer);	
		}, "text");
	})	
	
	// 3번과 같음
	$("#btn-5").click(function() {
		$.getJSON("/replies/96", function(data) {
			console.log(data);
			console.log(data.rno);
			console.log(data.bno);
			console.log(data.reply);			
			console.log(data.replyer);			
		});
	})	
	
})

</script>
</head>
<body>
<h1>AJAX ex6</h1>

<div>
<button id="btn-1">댓글 하나 가져오기</button>
</div>

<div>
<button id="btn-2">댓글 하나 가져오기2</button>
</div>

<div>
<button id="btn-3">댓글 하나 가져오기3</button>
</div>

<div>
<button id="btn-4">댓글 하나 가져오기4</button>
</div>

<div>
<button id="btn-5">댓글 하나 가져오기5</button>
</div>

</body>
</html>