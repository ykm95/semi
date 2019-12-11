<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/views/layout/headerAdmin.jsp"></jsp:include>
<br>

<script type="text/javascript">
	$(document).ready(function() {
		//로그인 버튼 클릭 시 form submit
		$("#btnLogin").click(function() {
			$(this).parents("form").submit();
		})

		//취소 버튼 누르면 뒤로가기
		$("#btnCancel").click(function() {
			history.go(-1);
		})

	});
</script>

<style type="text/css">
#wrap {
	width: 425px;
	height: 387px;
	border-radius: 25px;
	border:1px #e9e9e9 solid;
	margin: auto;
}

#wrap2 {
	width: 300px;
	height: 300px;
	display: inline-block;
	padding: 50px 20px;
	margin: 18px 0 0 53px;
}

#button {
	text-align: center;
}
</style>

<br>
<br>
<br>
<body style="background-color: #ced4da;">
	<div class="container" style="">

		<form action="/admin/login" method="post" class="form-horizontal">
			<!-- 	<fieldset style='margin: 0 auto;width:300px'> -->
			<div id="wrap" style="background-color: #f1f1f1;">
				<div id="wrap2">
					<h3 style="text-align: center;">관리자 로그인 🔑</h3>
					<br>
					<div class="form-group">
						<input type="text" name="adminid" id="adminid"
							class="form-control" placeholder="아이디">
					</div>
					<div class="form-group">
						<input type="password" name="adminpw" id="adminpw"
							class="form-control" placeholder="비밀번호">
					</div>
					<br>
					<div id="button" class="form-group">
						<button type="button" id="btnLogin" class="btn " style="background-color:#afd485">로그인</button>
						<button type="button" id="btnCancel" class="btn"style="background-color:#FA5858">취소</button>
					</div>
				</div>
			</div>
			<!-- 	</fieldset> -->
		</form>

	</div>
</body>




<jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>