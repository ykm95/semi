<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<jsp:include page="/WEB-INF/views/layout/header.jsp"/>

<style>

#title{
	width: 30px;
}

</style>

<h1>너 신고</h1>
<hr>

<table class="table">
	
<tr>
	<th colspan="1">신고레시피</th>
	<td colspan="3">${recipename }</td>
</tr>

</table>

<form action="/recipe/report" method="post">

<input type="hidden" name="recipeno" value="${recipeno }">

<table class="table">

<tr>
	<th id="title">제목sdsds</th>
	<td><input type="text" name="title"></td>
</tr>

<tr align="center">
	<th colspan="5">신고사유</th>
</tr>

<tr>
	<td><textarea style="width: 500px; height: 300px;" id="content" name="content"></textarea></td>
</tr>

</table>


<br><br>
<button>제출</button>
</form>

<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>