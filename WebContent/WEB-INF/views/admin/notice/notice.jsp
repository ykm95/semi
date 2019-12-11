<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/layout/headerAdmin.jsp"></jsp:include><br>
<!-- <script type="text/javascript" src="/ckeditor/ckeditor.js"></script> -->

<script type="text/javascript">
	$(document).ready(function() {

		$("#btnnotice").click(function() {

			console.log(noticesend);

			submitContents($("#btnnotice"));

			//form submit
			$("#notice").submit();
		})

	});
</script>
<style type="text/css">
div {
	margin: 10px;
}

#form {
	width: 600px;
	height: 400px;
	border-radius: 25px;
	border: 5px solid white;
	margin: auto;
	background-color:white;
}

#form2 {
	width: 500px;
	height: 500px;
	display: inline-block;
	padding: 50px 20px;
	margin: 18px 0 0 52px;
	text-align: center;
}
</style>

<body style="background-color: #f1f1f1;">
	<br>
	<br>
	<form id="notice" action="/admin/notice" method="POST" >
		<div id="form" style="background-color:#f1f1f1;">
			<div id="form2">
				<h3 style="text-align:center;">${member.userid }님에게 <br>알림보내기</h3><br>
				<select name="notice">
					<option value="신고글이 처리 되었습니다">신고글이 처리 되었습니다</option>
					<option value="문의글이 처리 되었습니다">문의글이 처리 되었습니다</option>
					<option value="부적절한 글로 신고되어  회원님의 글이 삭제처리 되었습니다">부적절한 글로 신고되어  회원님의 글이 삭제처리 되었습니다</option>
					<option value="부적절한 글로 신고되어  회원님의 글이 삭제처리 되었습니다">게시글에 광고가 포함되어 있어 삭제처리 되었습니다</option>
					<option value="욕설 및 부적절한 언어 사용으로 회원님의 댓글이 삭제 되었습니다">욕설 및 부적절한 언어 사용으로 회원님의 댓글이 삭제 되었습니다</option>
				</select> <input type="hidden" value="${param.userno }" name="userno">
				<br>
				<br>
				<div class="text-center">
					<button type="submit" id="btnnotice" class="btn" style="background-color:#afd485">작성</button>
				</div>
			</div>
		</div>
	</form>
</body>
<jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>