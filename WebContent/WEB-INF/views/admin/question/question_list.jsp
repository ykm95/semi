<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/layout/headerAdmin.jsp"></jsp:include><br>

<script type="text/javascript">
	$(document).ready(
			function() {

				//문의글 검색
				$("#btnqsearch").click(
						function() {
							location.href = "/adminquestion/list?search="
									+ $("#search2").val();

						})

			})
</script>

<!-- Bootstrap 3.3.2 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
table, th {
	text-align: center;
}

tr td:not (:first-child ), tr th:not (:first-child ) {
	border-left: 3px solid white;
}

#seach1 {
	top: 50%;
	left: 50%;
	margin: auto;
	display:inline-block;
}

#search2 {
	width: 200px;
	height: 30px;
}

.main, .user, .question, .recipe, .report {
	
	background-color:#afd485;
	border:3px #e9e9e9 solid;
 	padding: 15px; 
	display:inline-block;
	font-size: large;
	cursor: pointer;
}
.main:hover, .user:hover, .question:hover, .recipe:hover, .report:hover{
	background:white;
}


#list {
	border:3px #e9e9e9 solid;
	background-color:white;
	width: 600px;
	padding: 46px;
	
}
.menu{
	    width: 1050px;
   		padding: 500px;
}

#menu div {
	margin: 0 5px;
    padding: 15px;
    width: 18%;
}
</style>

<body style="background-color: #f1f1f1;">
	<div class="container">
		<div class="row">
			<div id="menu" style="width: 100%">
			<div class="main" ><a onclick="location.href='/admin/admain'">메인</a>
				</div>
			<div class="user"><a onclick="location.href='/admin/userlist'">회원관리</a>
				</div >
			<div class="question"><a onclick="location.href='/adminquestion/list'">문의관리</a>
				</div >
			<div class="recipe"><a onclick="location.href='/recipe/list'">게시글관리</a>
				</div >
			<div class="report"><a onclick="location.href='/adminreport/list'">신고글관리</a>
				</div >
			</div>	
		

		<div id="list"class="col-md-12" style="text-align:center;">
		<h1>1:1 문의 관리</h1>
		<br>
		<table class="table table-hover table-condensed">
			<tr class="success">
				<th>USER NO</th>
				<th>USER ID</th>
				<th>TITLE</th>
			</tr>
			<c:forEach items="${ qlist }" var="i">
				<tr>
					<td>${i.userno }</td>
					<td>${i.userid }</td>
					<td><a href="/adminquestion/view?userno=${i.userno}">${i.questitle }</a></td>
				</tr>
			</c:forEach>
		</table>
		<jsp:include page="/WEB-INF/views/admin/question/question_paging.jsp" />
		<div id="seach1">
			<input type="text" id="search2">
			<button id="btnqsearch">검색</button>
		</div>
		</div>
		</div>
		
	</div>
</body>

<jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>