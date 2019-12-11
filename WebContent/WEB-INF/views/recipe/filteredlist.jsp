<%@page import="web.dto.Recipe"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
    
<jsp:include page="/WEB-INF/views/layout/headerSearch.jsp"/>

<style>
td img{
	width: auto;
	height: 180px;
}
.form-control {
	width: 35%;
	display: inline;
}
.table>tbody>tr>td {
	vertical-align: inherit;
}
</style>
<div>

<c:choose>

<c:when test="${condition == 'category' and conditionnum == 1}"><h1>한식</h1></c:when>
<c:when test="${condition == 'category' and conditionnum == 2}"><h1>양식</h1></c:when>
<c:when test="${condition == 'category' and conditionnum == 3}"><h1>중식</h1></c:when>
<c:when test="${condition == 'category' and conditionnum == 4}"><h1>일식</h1></c:when>
<c:when test="${condition == 'category' and conditionnum == 5}"><h1>디저트</h1></c:when>
<c:when test="${condition == 'category' and conditionnum == 6}"><h1>음료</h1></c:when>

<c:when test="${condition == 'ocassion' and conditionnum == 1}"><h1>일상</h1></c:when>
<c:when test="${condition == 'ocassion' and conditionnum == 2}"><h1>초간단</h1></c:when>
<c:when test="${condition == 'ocassion' and conditionnum == 3}"><h1>간식</h1></c:when>
<c:when test="${condition == 'ocassion' and conditionnum == 4}"><h1>야식</h1></c:when>
<c:when test="${condition == 'ocassion' and conditionnum == 5}"><h1>다이어트</h1></c:when>
<c:when test="${condition == 'ocassion' and conditionnum == 6}"><h1>해장</h1></c:when>

</c:choose>

<hr>
<table class="table table-hover">
<tr class="success">
	<th style="width: 15%">게시판 번호</th>
	<th style="width: 25%">제목</th>
	<th style="width: 15%">아이디</th>
	<th style="width: 25%">사진</th>
	<th style="width: 20%">조회수</th>
</tr>


<c:forEach var="list" items="${list }">
<tr onclick="location.href='/recipe/view?recipeno=${list.recipeno }'">
	<td>${list.recipeno }</td>
	<td>
		<a href="/recipe/view?recipeno=${list.recipeno }">
		${list.recipename }</a>
	</td>
	<td>${list.nick }</td>
	<td style="text-align: center;">
		<c:choose>
		<c:when test="${list.recipic ne '/upload/null'}"><img src="${list.recipic }"></c:when>
		<c:when test="${list.recipic eq '/upload/null'}"><div style="width: 100%; height: 180px;"></div></c:when>
	</c:choose>
	</td>
	<td>${list.hit }</td>
	
</tr>
</c:forEach>

</table>

<a href="/main"><button class="btn">메인</button></a>
	<a href="/recipe/reg"><button class="btn">등록</button></a>
	<form action="/recipe/filter" method="get">
	<br>
<!-- 		<select name="condition"> -->
<!-- 			<option value="name">제목</option> -->
<!-- 			<option value="ingredient">재료</option> -->
<!-- 		</select> -->
		<input type="hidden" name="${condition }" value="${conditionnum }">
		<input type="text" id="search" name="search" class="form-control"/>
		&nbsp;
		<button id="btnSearch" class="btn">검색</button>
	</form>
</div>

<jsp:include page="/WEB-INF/views/recipe/filtered_paging.jsp" />

<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>