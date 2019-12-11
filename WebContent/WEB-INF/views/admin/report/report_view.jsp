<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/layout/headerAdmin.jsp"></jsp:include><br>

<!-- Bootstrap 3.3.2 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<style type="text/css">
#report {
	background-color: white;
	width: 1100px;
	border: 3px #e9e9e9 solid;
	
}

tr th {
	text-align:center;
}
</style>

<body style="background-color: #f1f1f1;">

<div class="container">
	<div id="report">
		<div class="col-md-12" style="text-align: center;">
			<h1>${viewReport.userid }님의 신고글</h1>

			<table class="table table-hover table-condensed">
				<tr class="success" >
					<th>신고 글번호</th>
					<th>레시피 이름</th>
					<th>USER NO</th>
				</tr>
				<tr>
					<td>${viewReport.reportno }</td>
					<td><a
						href="/recipe/view?recipeno=${ viewReport.recipeno}">${viewReport.recipename }</a></td>
					<td>${viewReport.userno }</td>
				</tr>
				<tr class="success">
					<th colspan="3">신고내용</th>

				</tr>
				<tr>
					<th colspan="3">
						<div style="min-height: 200px; text-align:center;">${viewReport.repocontent }</div>
					</th>
				</tr>

			</table>
		</div>
		<div class="text-center">
			<button type="button" id="btnAnwer" class="btn" style="background-color:#afd485"
				onclick="location.href='/admin/notice?userno=${viewReport.userno }'">알림보내기</button>
		</div>
		<br>
	</div>
	</div>
</body>

<jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>