<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">


function tocheckpw2() {
	
var pw = document.getElementById("userpw").value;
var pwck = document.getElementById("userpwch").value;
if (pw != pwck) {
	document.getElementById('pwsame').innerHTML = '비밀번호가 일치하지 않습니다. 다시 입력해 주세요';
	return false
}	


var re_1 = /^[a-z0-9A-Z]{4,10}$/;
var pw_1 = document.getElementById("userpw");

if(!check_1(re_1,pw_1,"비밀번호는 4~10자의 소문자와 숫자로 입력")) {
    return false;
}	
function check_1(re_1, what, message) {
	if(re_1.test(what.value)) {
		return true;
	}
 	document.getElementById('pwval').innerHTML = message;
	what.value = "";
	what.focus();
}

}
</script>


<body style="background-color:#F7F7F4">
<div class="page-header" style="text-align: center;  margin: 60px 2px 56px;" >
<h2> 비밀번호 변경 </h2><br>

<div style="text-align:center;height: 124px;width: 374px;margin-left: 247px;">	
	<form method="post" action="/member/findpw" onsubmit="return tocheckpw2()" data-ajax="false">
	<div style="text-align:center; height: 48px;">
		<label for="userpw"></label>
		<input type="password" id="userpw" name="userpw" class="form-control" placeholder="비밀번호" maxlength="10"/><br>	
	</div>
	<div style="text-align:center; height: 100px;">
		<label for="userpwch"></label>
		<input type="password" id="userpwch" name="userpwch" class="form-control" placeholder="비밀번호 확인" maxlength="10"/><br>	
		<div id="pwsame" style="color:red;margin: -11px;"></div>
		<br><br>
		<div id="pwval" style="color:red; margin: -26px;" ></div>
	<div style="text-align:center"><br><br><br><br>
		<input type="hidden" name="userno" value="${userno }"/>
		<button class="btn btn-success btn-block" style="background: #5BB88B;">변경 완료</button>
	</div>
		
</div>
</form>
</div>
	</div>
</html>