<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include><br>

<script type="text/javascript">
$(document).ready(function(){

	//문의글 검색
	$("#btnqsearch").click(function(){
		location.href="/question/list?search="+$("#qsearch").val();
		
	})
	
})

</script>

<!-- Bootstrap 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type = "text/css">
table, th {
	text-align: center;
}
</style>

<jsp:include page="/WEB-INF/views/layout/menu.jsp"></jsp:include>

<div class="container">
	<h1>1:1 문의 관리</h1>
	<hr>
		<table class="table table-hover table-condensed table-striped">
			<tr class ="success">
				<th>USER NO</th>
				<th>제목</th>
			</tr>
			<c:forEach items="${ qlist }" var="i">
				<tr>
					<td>${i.userno }</td>
					<td><a href="/question/view?userno=${i.userno}">${i.questitle }</a></td>
				</tr>
			</c:forEach>
		</table>
	<jsp:include page="/WEB-INF/views/admin/question_paging.jsp"/>
		
		<div class="form-inline text-center">
		<input class="form-control" type="text" id="qsearch">
		<button id ="btnqsearch">검색</button>
	</div>
		
</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>