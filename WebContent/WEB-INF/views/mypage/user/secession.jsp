<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/layout/headerSearch.jsp"/>


<script type="text/javascript">

$(document).ready(function(){
	
	$('#btnExit').click(function(){
		
		history.go(-1);
	});
	
});

</script>

<div class="container">

<div style="text-align: center;">
<h1>회원 탈퇴</h1>
<br><br>
</div>

<div style="width: 500px; margin: 0 auto;">
1. 사용하고 계신 계정은 탈퇴할 경우 재사용 및 복구가 불가능합니다.
타인은 물론 본인 역시 재사용이 불가능하므로 신중하게 선택하시기 바랍니다.
</div>

<br><br>

<div style="width: 500px; margin: 0 auto;">
2. 개인 정보 및 이용 기록은 모두 삭제됩니다. 회원 개인에 대한 정보는 모두 삭제되며,
 삭제된 데이터는 복구되지 않습니다.
</div>

<br><br>

<div style="width: 500px; margin: 0 auto;">
3. 탈퇴 후에도 공유해주신 레시피는 그대로 남아 있습니다. 
만일 삭제를 원하신다면, 탈퇴 전 삭제해 주시기 바랍니다. 
탈퇴와 함께 모든 회원 정보는 완전히 지워집니다. 
따라서 탈퇴 후에는 본인 확인이 불가능하기 때문에 작성한 레시피를 삭제할 수 없습니다.
</div>

<br><br>

<div style="text-align: center;">
	<form action="/mypage/user/secession" method="post" name="chk">
		<input type="checkbox" id="chk" required="required"> <label for="chk">해당 약관에 동의합니다</label>
		<br><br>
	<button id="btnSecession" class="btn btn-default">회원 탈퇴</button>  <button id="btnExit" class="btn btn-danger">취소</button>
	</form>
</div>

</div>


<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>