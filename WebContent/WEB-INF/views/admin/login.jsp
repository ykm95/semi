<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include>
<br>

<script type= "text/javascript">
$(document).ready(function(){
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

<div class ="container" style="center">

<form action ="/admin/login" method="post" class="form-horizontal">
	<fieldset style='margin: 0 auto;width:300px'>
		<legend>관리자 로그인</legend><br>
			<div class="form-group">
				<input type="text" name="adminid" id="adminid"class="form-control" placeholder="아이디">
			</div>
			<div class="form-group">			
				<input type="text" name ="adminpw" id="adminpw" class="form-control" placeholder="비밀번호">
			</div>		
			<div class="form-group">
				<button type="button" id="btnLogin" class="btn btn-success" >로그인</button>
				<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
			</div>	
	</fieldset>
</form>

</div>





<jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>