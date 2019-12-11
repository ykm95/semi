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

<script type="text/javascript">
function w3_open() {
	  document.getElementById("all").style.marginLeft = "25%";
	  document.getElementById("mySidebar").style.width = "25%";
	  document.getElementById("mySidebar").style.display = "block";
	  document.getElementById("openNav").style.display = 'none';
	}
	function w3_close() {
	  document.getElementById("all").style.marginLeft = "0%";
	  document.getElementById("mySidebar").style.display = "none";
	  document.getElementById("openNav").style.display = "inline-block";
	}
</script>

</head>

<!-- header -->

<div class="w3-sidebar w3-bar-block w3-card w3-animate-left" style="display:none" id="mySidebar">
  <button class="w3-bar-item w3-button w3-large"
  onclick="w3_close()">Close &times;</button>
  <h5>&nbsp;&nbsp;종류별</h5>
  <ul style="list-style: none;">
  	<li><a href="/recipe/filter?category=1" class="w3-bar-item w3-button">한식</a></li>
  	<li><a href="/recipe/filter?category=2" class="w3-bar-item w3-button">양식</a></li>
  	<li><a href="/recipe/filter?category=3" class="w3-bar-item w3-button">중식</a></li>
  	<li><a href="/recipe/filter?category=4" class="w3-bar-item w3-button">일식</a></li>
  	<li><a href="/recipe/filter?category=5" class="w3-bar-item w3-button">디저트</a></li>
  	<li><a href="/recipe/filter?category=6" class="w3-bar-item w3-button">음료</a></li>
  </ul>
  <h5>&nbsp;&nbsp;상황별</h5>
  <ul style="list-style: none;">
  	<li><a href="/recipe/filter?ocassion=1" class="w3-bar-item w3-button">일상</a></li>
  	<li><a href="/recipe/filter?ocassion=2" class="w3-bar-item w3-button">초간단</a></li>
  	<li><a href="/recipe/filter?ocassion=3" class="w3-bar-item w3-button">간식</a></li>
  	<li><a href="/recipe/filter?ocassion=4" class="w3-bar-item w3-button">야식</a></li>
  	<li><a href="/recipe/filter?ocassion=5" class="w3-bar-item w3-button">다이어트</a></li>
  	<li><a href="/recipe/filter?ocassion=6" class="w3-bar-item w3-button">해장</a></li>
  </ul>
</div>


<div style="height: 20px; background: #AED584; "></div>

<body style="background: #FFFFFF">

<div id="all">

<div class="row" style="border-bottom: 1px solid #CCC; padding-bottom: 50px">



	<div class="col-md-2" style="text-align: center; padding-top: 30px">
		<a href="/main"><img width="120px" height="120px" src="/resources/img/세모레_로고.png"></a>
	</div>
	
	<div class="col-md-8" style="text-align: center; padding-top: 80px">
		<form action="/recipe/list" method="get">
			<div class="form-group">
				<input type="text" class="form-control" name="search" style="text-align: left; display: inline; width:80%">
				&nbsp;
				<button class="btn btn-info">검색</button>
			</div>
		</form>
	</div>
	
	<div class="col-md-2" style="padding-top: 15px; text-align: center;">
		<c:if  test="${not login }">
		<a href="/member/login"><button class="btn btn-xs">로그인</button></a>
		</c:if>
			
		<c:if  test="${login }">
		<a href="/member/logout"><button class="btn btn-sm" style="width: 65px">로그아웃</button></a>
		<a href="/mypage/myrecipe"><button class="btn btn-sm" style="width: 77px">마이페이지</button></a>
		</c:if>
	</div>
	
	
</div> <!-- row -->

<div class="w3-teal" style="display: inline-block; background-color: #afd485!important;">
  <button id="openNav" class="w3-button w3-teal w3-xlarge" onclick="w3_open()">&#9776;</button>
  <div class="w3-container">
  </div>
</div>

<br>

<!-- content -->
<div class="container pt-3" id="wrapper">