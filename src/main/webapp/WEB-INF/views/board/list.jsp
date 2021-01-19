<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
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

<script>
	$(document).ready(function() {
		
		var result = '${result }';
		var resultModify = '${resultModify}';
		var resultRemove = '${resultRemove}';
		
		checkModal(result);
		checkModal(resultModify);
		checkModal(resultRemove);
		
		history.replaceState({}, null, null);
		
		function checkModal(result){
			
			if (result === '' || history.state) {
				return;
			}
			if(result === '') {
				return;
			}
			
			if(parseInt(result) > 0) {
				$("#myModal .modal-body p").html("게시글 " + result + "번이 등록 되었습니다.");
			}
		
			if(parseInt(resultModify) > 0) {
				$("#myModal .modal-body p").html("게시글 " + resultModify + "번이 수정 되었습니다.");		
			}
			
			if(parseInt(resultRemove) > 0) {
				$("#myModal .modal-body p").html("게시글 " + resultRemove + "번이 삭제 되었습니다.");		
			}
			
			$("#myModal").modal("show");	
		}
	});
</script>

<title>Insert title here</title>
</head>
<body>

result : ${result }
<u:navbar></u:navbar>

<div class="container-sm">
  <div class="row">

    <!-- .table.table-striped.table-hover>thread+today -->
    <table class="table table-striped table-hover">
      <thead>
        <tr>
          <th>#번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>작성일</th>
          <th>수정일</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${list}" var="board">
          <tr>
            <td>${board.bno} </td>
            
            <td>
            <a href="${root }/board/get?bno=${board.bno }">
            	<c:out value="${board.title}"/>
            </a>
            </td>     
               
            <td><c:out value="${board.writer}"/> </td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" 
              value="${board.regdate}" /> </td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" 
              value="${board.updatedate}" /> </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>

</div>

<div id="myModal" class="modal" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">알림</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>Modal body text goes here.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<div class="container-sm mt-3">
	<div class="row justify-content-center">
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		  
		  	<c:if test="${pageMaker.prev }">
		    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
		  	</c:if>
		  	
		  	<c:forEach var="num" begin="${pageMaker.startPage }" 
		  						end="${pageMaker.endPage }">
		    <li class="page-item"><a class="page-link" href="#">${num }</a></li>

		  	</c:forEach>
		    
		    <c:if test="${pageMaker.next }">
		    <li class="page-item"><a class="page-link" href="#">Next</a></li>
		    </c:if>
		    
  		</ul>
		</nav>
	
	</div>
</div>
</body>
</html>