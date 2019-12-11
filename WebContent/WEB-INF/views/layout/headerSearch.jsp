<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html>
<html>
<head>
<title>세모레 :: Home</title>

<!-- 부트스트랩 사용하기 위해서 jQuery가 필요하므로 먼저 적어준다 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- JS -->
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">


<style type="text/css">


@font-face { font-family: 'Handon3gyeopsal300g'; 
src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_seven@1.2/Handon3gyeopsal300g.woff') format('woff'); 
font-weight: normal; font-style: normal; }


.header-font{
	font-family: 'Handon3gyeopsal300g'; 
}

</style>

</head>

<!-- header -->


<div style="height: 20px; background: #AED584; "></div>

<body style="background: #FFFFFF; padding-bottom: 0px;" class="header-font">

<div class="row" style="border-bottom: 1px solid #CCC; padding-bottom: 50px">

	<div class="col-md-2" style="text-align: center; padding-top: 30px">
		<a href="/main"><img width="120px" height="120px" src="/resources/img/세모레_로고.png"></a>
	</div>
	
	<div class="col-md-8" style="text-align: center; padding-top: 80px">
		<form action="/recipe/list" method="get">
			<div class="form-group">
				<input type="text" class="form-control" name="search" style="text-align: left; display: inline; width:80%">
				<button class="btn btn-info">검색</button>
			</div>
		</form>
	</div>
	
	<div class="col-md-2" style="padding-top: 15px; text-align: right;">
		<c:if  test="${not login }">
		<a href="/member/login"><button class="btn btn-sm">로그인</button></a>
		</c:if>
			
		<c:if  test="${login }">
		<a href="/member/logout"><button style="width: 65px" class="btn btn-sm">로그아웃</button></a>
		<a href="/mypage/myrecipe"><button style="width: 77px" class="btn btn-sm">마이페이지</button></a>
		</c:if>
	</div>
	
	
</div> <!-- row -->

<div style="height: 20px; background: #AED584; "></div>

<br><br><br>


<!-- content -->
<div class="container pt-3" id="wrapper">