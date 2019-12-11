<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="web.dto.Recipe"%>
<%@page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
    
<jsp:include page="/WEB-INF/views/layout/header.jsp"/>
<%  List<Recipe> eList = (List) request.getAttribute("list"); %> 
    
<div>

<h1>게시판</h1>
<hr>
<table>
<tr class="info">
	<th style="width: 10%">순서</th>
	<th style="width: 15%">제목</th>
	<th style="width: 15%">아이디</th>
	<th style="width: 20%">사진</th>
	<th style="width: 20%">조회수</th>
	<th style="width: 20%">날짜</th>
</tr>
<% for(int i=0; i<eList.size(); i++ ) { %>
<tr>
	<td><%=eList.get(i).getRecipeno() %></td>
	<td>
		<a href="/recipe/view?recipeno=<%=eList.get(i).getRecipeno() %>">
		<%=eList.get(i).getRecipename() %></a>
	</td>
	<td><%=eList.get(i).getNick() %></td>
	<td>
		<img src="<%=eList.get(i).getRecipic() %>"/>
	</td>
	<td><%=eList.get(i).getHit() %></td>
	
</tr>
<% } %>

</table>

<a href="/main"><button>메인</button></a>
	<a href="/recipe/reg"><button>등록</button></a>

	<form action="/recipe/list" method="get">
		<select name="condition">
			<option value="name">제목</option>
			<option value="ingredient">재료</option>
		</select>
		<input type="text" id="search" />
		<button id="btnSearch">검색</button>
	</form>
</div>


<jsp:include page="/WEB-INF/views/recipe/recipe_paging.jsp" />

<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>