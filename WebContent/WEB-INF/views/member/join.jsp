<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세모레 ::: 회원가입</title>


</head>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	$("#idcheck").click(function() {
// 		console.log(123);
		
		$.ajax({
			type: "POST"
			, url: "/member/check"
			, data: { "userid": $("#userid").val() }
			, dataType: "json"
			, success: function(data){
				console.log("ajax성공")
				$("#message").html(data.cen);
// 				$("#message").css("color", "red")
			}
			, error: function(){
				console.log("ajax실패")
			}
			
		});
	});


});
</script>


<script type="text/javascript">
function tocheckpw2() {
	
	var re = /^[a-z0-9]{4,10}$/;
	var id = document.getElementById("userid");	
	
	if(!check(re,id,"아이디는 4~10자의 소문자와 숫자로 입력")) {
        return false;
    }	
	function check(re, what, message) {
		if(re.test(what.value)) {
			return true;
		}
	 	document.getElementById('idval').innerHTML = message;
		what.value = "";
		what.focus();
	}
	
	
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
<div class="container" style="width:400px;">
<div class="page-header" style="text-align: center; padding-bottom: 28px; margin: 60px 2px 56px;" >
<h1> 회원가입 </h1>
</div>
<form action ="/member/join" method="post"  onsubmit="return tocheckpw2()"  data-ajax="false">

	<div style="text-align:center; height: 124px;">
		<label for="userid"></label>
		<input type="text" id="userid" name="userid" placeholder="아이디" maxlength="10" class="form-control" />
		<p style="color:red;height: 15px;" id="idval" ></p>
		<button class="btn" type="button" id="idcheck" style="position: relative; left: -144px;" >중복체크</button>
		<div id="message" style="position: relative;  top: -27px; z-index: -9999" ></div>
		<br>	
	</div>
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
	</div>
	<div style="text-align:center;height: 48px;" >
		<label for="email"></label>
		<input class="form-control" type="email" id="email" name="email" placeholder="이메일"><br>	
	</div>
	<div style="text-align:center">
		<label for="nick"></label>
		<input type="text" id="nick" name="nick" placeholder="닉네임"	class="form-control"></input>
	</div>
	<div style="text-align:center"><br><br><br><br>
		<button class="btn btn-success btn-block" style="background: #5BB88B;">회원가입</button>
	</div>
	</form>	
	</div>
</body>
</html>