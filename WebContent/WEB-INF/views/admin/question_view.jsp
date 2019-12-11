<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include><br>

<!-- Bootstrap 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>



<style type="text/css">
div{
	margin:10px;
}

</style>
<jsp:include page="/WEB-INF/views/layout/menu.jsp"></jsp:include>

<!-- 	<div style="width:1092px; height:400px; text-align:center;  -->
<!-- 	 font-size:16px; border: 1px solid black;"> -->
<!-- 	</div> -->
<div class="container">
<h1>1:1 문의</h1>
	<hr>
	<table class="table table-hover table-condensed">
		<tr class="success">
			<th>문의 글번호</th>
			<th>회원번호</th>
			<th>제목</th>
		</tr>
		<tr>
			<td>${viewQuestion.questionno }</td>
			<td>${viewQuestion.userno }</td>
			<td>${viewQuestion.questitle }</td>
		</tr>
		<tr class="success">
			<th colspan="3">문의내용</th>
			
		</tr>
		<tr>
			<th colspan="3">
				<div style="min-height:200px">
					${viewQuestion.question }
				</div>
			</th>
		</tr>
		<tr class="success">
			<th colspan="3">답변</th>
		</tr>
		<tr>
			<th colspan="3">
				<div style="min-height:200px">
					${viewQuestion.answer }
				</div>
			</th>
		</tr>
		
<!-- 		<tr> -->
<%-- 			<td>${viewQuestion.question }</td> --%>
<!-- 		</tr> -->
	</table>
</div>
	<div class="text-center">
		<button type="button" id="btnAnwer" class="btn btn-success" onclick="location.href='/quesiton/answer?userno=${viewQuestion.userno }'">답변하기</button>
	</div>
<jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>