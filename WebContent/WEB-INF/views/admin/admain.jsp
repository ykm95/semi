<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/layout/headerAdmin.jsp"></jsp:include>

<style  type="text/css">



</style>

<body style="background-color: #f1f1f1;">
<div style="text-align: center;">
	<fieldset style='margin: 0 auto; width:500px'><br><br>

		<h1>관리자 페이지 입니다 ✋</h1><br>
			
				<c:if test="${not adminlogin }">
					<h3 style="color:red;">로그인이 필요합니다</h3><br>
						<div onclick='location.href="/admin/login";' style="cursor:pointer">
						<img src="/image/로그인.png" width="80"><br>
						로그인
						</div>
				</c:if>
				<c:if test="${adminlogin }">
					<strong>관리자계정으로 로그인 되었습니다.</strong><br><br>
						
						<div onclick="location.href='/admin/userlist'" style="cursor:pointer">
							<img src="/image/회원관리.png" width="80"><br>
							회원관리
						</div>
						<div onclick="location.href='/adminquestion/list'" style="cursor:pointer">
							<img src="/image/문의.png" width="80"><br>
							1:1 문의관리
						</div>
						<div onclick="location.href='/recipe/list'" style="cursor:pointer">
							<img src="/image/게시글관리.png" width="80"><br>
							게시글 관리
						</div>
						<div onclick="location.href='/adminreport/list'" style="cursor:pointer">
							<img src="/image/신고글.png" width="80"><br>
							신고글 관리
						</div>
						<div onclick="location.href='/admin/logout'" style="cursor:pointer">
							<img src="/image/로그아웃.png" width="80"><br>
							로그아웃
						</div>
						
				</c:if>
		

	</fieldset>

</div>
</body>


<jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>