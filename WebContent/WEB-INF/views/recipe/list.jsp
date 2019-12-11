<%@page import="web.dto.Recipe"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
    
<jsp:include page="/WEB-INF/views/layout/headerSearch.jsp"/>   

<style>
.thumbnail{
	height: 310px; 
}
.thumbnail img{ 
	height: 200px;  
	margin-top: 10px;
}
.form-control {
	width: 35%;
	display: inline;
}
.caption p {
	text-align: right;
}
</style>

<div>

<h1>검색결과</h1>
<hr>

<c:choose>

<c:when test="${titlepaging.totalPage ne 0 or ingpaging.totalCount ne 0 }">
<c:if test="${titlepaging.totalPage ne 0 }">
<c:choose>
<c:when test="${titlepaging.search ne null }"><h3>제목으로 검색한 결과 입니다</h3></c:when>
<c:when test="${titlepaging.search eq null or titlepaging.search eq '' or search eq null or search eq ''}"><h3>레시피 목록</h3></c:when>
</c:choose>
<br>

<div class="row">
<c:forEach items="${recipe }" var="recipe">
  <div class="col-sm-6 col-md-4" onclick="location.href='/recipe/view?recipeno=${recipe.recipeno }'">
    <div class="thumbnail">
      <img src="${recipe.recipic }" class="pic">
      <div class="caption">
        <h3>${recipe.recipename }</h3>
        <p>by. ${recipe.nick }</p>        
      </div>
    </div>
  </div>
</c:forEach>
</div>

<a href="/main"><button class="btn">메인</button></a>
&nbsp;
<a href="/recipe/reg"><button class="btn">등록</button></a>
&nbsp;
<a href="/search/name?&search=${titlepaging.search}"><button class="btn">더보기</button></a>

	<form action="/search/name" method="get">
		<br>
		<input type="text" id="namesearch" name="search"  class="form-control"/>
		&nbsp;
		<button id="btnSearch" class="btn">검색</button>
	</form>
	
<hr>
</c:if>

<c:if test="${ingpaging.totalCount ne 0 }">
<h3>재료로 검색한 결과 입니다</h3>
<br>
<div>

<div class="row">
<c:forEach items="${recipenoList }" var="recipe">
  <div class="col-sm-6 col-md-4" onclick="location.href='/recipe/view?recipeno=${recipe.recipeno }'">
    <div class="thumbnail">
      <img src="${recipe.recipic }">
      <div class="caption">
        <h3>${recipe.recipename }</h3>
        <p>by. ${recipe.nick }</p>        
      </div>
    </div>
  </div>
</c:forEach>
</div>

	<a href="/main"><button class="btn">메인</button></a>
	&nbsp;
	<a href="/recipe/reg"><button class="btn">등록</button></a>
	&nbsp;
	<a href="/search/ingredient?search=${titlepaging.search}"><button class="btn">더보기</button></a>
	
	<form action="/search/ingredient" method="get">
		<br>
		<input type="text" id="ingredientsearch" name="search" class="form-control"/>
		&nbsp;
		<button id="btnSearch" class="btn">검색</button>
	</form>
</div>
</c:if>
</c:when>

<c:otherwise>
<br>
<h2>결과가 없습니다</h2>
<h5>이런 메뉴는 어떠세요?</h5>

<div class="row">
<c:forEach items="${todaysmenu }" var="recipe">
  <div class="col-sm-6 col-md-4" onclick="location.href='/recipe/view?recipeno=${recipe.recipeno }'">
    <div class="thumbnail" style="height: 350px">
		<c:choose>
			<c:when test="${recipe.recipic ne '/upload/null'}">
				<img src="${recipe.recipic }">
			</c:when>
			<c:when test="${recipe.recipic eq '/upload/null'}">
				<img src="/upload/default.jpg">
			</c:when>
		</c:choose>
      <div class="caption">
        <h3>${recipe.recipename }</h3>
        <p>by. ${recipe.nick }</p>        
      </div>
    </div>
  </div>
</c:forEach>
</div>

</c:otherwise>

</c:choose>
<br>
</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>