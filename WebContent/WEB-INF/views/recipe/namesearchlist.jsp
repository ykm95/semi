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
<c:when test="${paging.search eq '' }"><h3>레시피 목록</h3></c:when>
<c:when test="${paging.search ne null }"><h3>제목별 검색</h3></c:when>
</c:choose>

<hr>
<table class="table table-hover">
<tr class="success">
	<th style="width: 10%">레시피번호</th>
	<th style="width: 15%">레시피제목</th>
	<th style="width: 25%">레시피설명</th>
	<th style="width: 20%">레시피작성자</th>
	<th style="width: 30%">완성사진</th>
</tr>
<c:forEach items="${recipe }" var="recipe">
<tr onclick="location.href='/recipe/view?recipeno=${recipe.recipeno }'">
	<td>${recipe.recipeno }
	<td><a href="/recipe/view?recipeno=${recipe.recipeno }">${recipe.recipename }</a></td>
	<td>${recipe.recipeex }</td>
	<td>${recipe.nick }</td>
	<td style="text-align: center;">
	<c:choose>
		<c:when test="${recipe.recipic ne '/upload/null'}"><img src="${recipe.recipic }"></c:when>
		<c:when test="${recipe.recipic eq '/upload/null'}"><div style="width: 100%; height: 180px;"></div></c:when>
	</c:choose>
	</td>
</tr>
</c:forEach>
</table>

<a href="/main"><button class="btn">메인</button></a>
&nbsp;
<a href="/recipe/reg"><button class="btn">등록</button></a>
	
</div>

<jsp:include page="/WEB-INF/views/recipe/recipe_paging.jsp" />

<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>