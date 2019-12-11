<%@page import="web.dto.Recipe"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
    
<jsp:include page="/WEB-INF/views/layout/header.jsp"/>
<%  List<Recipe> eList = (List) request.getAttribute("list"); %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>게시판</h1>
<hr>
<table>
<tr class="info">
	<th style="width: 5%">순서</th>
	<th style="width: 35%">제목</th>
	<th style="width: 15%">아이디</th>
<!-- 	<th style="width: 20%">내용</th> -->
	<th style="width: 10%">조회수</th>
	<th style="width: 30%">날짜</th>
</tr>
<% for(int i=0; i<eList.size(); i++ ) { %>
<tr>
	<td><%=eList.get(i).getRecipeno() %></td>
	<td>
		<a href="/board/view?recipeno=<%=eList.get(i).getRecipeno() %>">
		<%=eList.get(i).getRecipename() %></a>
	</td>
	<td><%=eList.get(i).getRecipeno() %></td>
	
</tr>
<% } %>



</table>
</body>
</html>



<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>