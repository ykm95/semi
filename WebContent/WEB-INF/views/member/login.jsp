<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세모레 ::: 로그인</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>




    
<script type="text/javascript">
$(document).ready(function(){
   
    // 저장된 쿠키값을 가져와서 ID 칸에 넣어준다. 없으면 공백으로 들어감.
    var key = getCookie("key");
    $("#userid").val(key); 
     
    if($("#userid").val() != ""){ // 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
        $("#loginChk").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
    }
     
    $("#loginChk").change(function(){ // 체크박스에 변화가 있다면,
        if($("#loginChk").is(":checked")){ // ID 저장하기 체크했을 때,
            setCookie("key", $("#userid").val(), 7); // 7일 동안 쿠키 보관
        }else{ // ID 저장하기 체크 해제 시,
            deleteCookie("key");
        }
    });
     
    // ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
    $("#userid").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
        if($("#loginChk").is(":checked")){ // ID 저장하기를 체크한 상태라면,
            setCookie("key", $("#userid").val(), 7); // 7일 동안 쿠키 보관
        }
    });
});
 
function setCookie(cookieName, value, exdays){
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
    document.cookie = cookieName + "=" + cookieValue;
}
 
function deleteCookie(cookieName){
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate() - 1);
    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
}
 
function getCookie(cookieName) {
    cookieName = cookieName + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(cookieName);
    var cookieValue = '';
    if(start != -1){
        start += cookieName.length;
        var end = cookieData.indexOf(';', start);
        if(end == -1)end = cookieData.length;
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
}
</script>





</head><body style="background-color:#F7F7F4">
<div class="container" style="width:400px;">
	<div class="page-header" style="text-align: center; padding-bottom: 28px; margin: 60px 2px 56px;" ><h2>로그인</h2></div>
	<form action ="/member/login" method="post" class="panel-body">
		<label for="userid"></label>
		<input class="form-control" type="text" id="userid" name="userid" placeholder="아이디"/>
		
		<br>

		<label for="userpw"></label>
		<input  class="form-control" type="password" id="userpw" name="userpw" placeholder="비밀번호" /><br>
		<br><br>
		
	<button  class="btn btn-success btn-block" style="background: #5BB88B;"  >로그인</button>
	<label for="loginChk" style="cursor:pointer"><input type="checkbox" id="loginChk" name="loginChk" value="true">아이디 저장<br></label> 
	<br>
	<p class="help-block">개인정보 보호를 위해 개인 PC에서만 사용하세요.</p>
	<hr>
	</form>


<div style="text-align:center">
<div class="btn">
<a href='/main' class="btn btn-default btn-sm" style="width:110px">뒤로가기</a>
<a href="/agree.jsp" class="btn btn-default btn-sm" style="width:110px">회원가입</a>

<form action ="/member/find" method="get" class="panel-body">
<a href="/member/find" type="button" class="btn btn-default btn-sm"  style="width:110px"
 onclick="window.open(this.href, '_blank', 'width=650px,height=350px,toolbars=no,scrollbars=no'); return false;">비밀번호 찾기</a>
</form>

<!-- <a href="/member/find" class="btn btn-default btn-sm" style="width:110px">비밀번호 찾기</a> -->
</div></div></div>


</body>
</html>