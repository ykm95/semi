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

<body style="background-color:#F7F7F4">
<div class="container" style="width:450px;">
<div class="page-header" style="text-align: center;  margin: 60px 2px 56px;" >
<h2> 비밀번호 찾기 </h2><br>
<h4>아이디를 입력하세요</h4></div>

<div style="text-align:center; height: 124px;">	

	<form method="post" action="/member/find">
		<label for="userid"></label>
		<input type="text" id="userid" name="userid" placeholder="아이디를 입력하세요"  class="form-control" /><br>
		<br>
		<button style="text-align:center" class="btn" id="check" style="position: relative; left: 144px;" > 인증하기 </button>
		<br>
		
	</form>
	</div>
	</div>
</html>