<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include>

<script type ="text/javascript">
$(document).ready(function(){

	//회원 검색
	$("#btnsearch").click(function(){
		location.href="/admin/list?search="+$("#search").val();
	});
	
	//회원 탈퇴
	$("#btndelete").click(function(){
		$(location).attr("href","/user/delete?userno=${i.userno }");
	})
	
});
</script>

<!-- Bootstrap 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style type="text/css">
table, th{
	text-align: center;
}

</style>

<jsp:include page="/WEB-INF/views/layout/menu.jsp"></jsp:include>

<div class="container">
<h1>회원 관리 </h1>
<hr>
	<table class="table table-hover table-condensed table-striped">
		<tr class="success">
			<th>USER NO</th>
			<th>아이디</th>
			<th>e-mail</th>
			<th colspan="4">닉네임</th>
			
		</tr>	
		<c:forEach items="${ list }" var="i">
   			<tr style="text-align:center; height:30">
		      <td>${ i.userno }</td>
		      <td>${ i.userid }</td>
		      <td>${ i.email }</td>
		      <td>${ i.nick }</td>
		      <td><a href="/admin/view?userno=${i.userno }"><button>정보확인</button></a></td>
		      <td><button>메시지전송</button></td>
		      <td><a href="/user/delete?userno=${i.userno }"><button id="btndelete" class="btn btn-danger btn-xs">회원탈퇴</button></a></td>
   			</tr>
		</c:forEach>
	</table>	
	<jsp:include page="/WEB-INF/views/admin/user_paging.jsp"/>
	
	<div class="form-inline text-center">
		<input class="form-control" type="text" id="search">
		<button id ="btnsearch">검색</button>
	</div>
	
</div>



<jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>