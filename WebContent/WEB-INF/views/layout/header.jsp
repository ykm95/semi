<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html>
<html>
<head>
<title>세모레 :: Home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="https://fonts.googleapis.com/css?family=Poppins:400,800" rel="stylesheet" />
<link href="css/main.css" rel="stylesheet" />

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
<body>
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

<div id="all">
<div class="jumbotron text-center mb-0">

<table>
<tr style="text-align: center;">
	<td><a href="/main"><img width="100px" height="100px" src="/resources/img/세모레_로고.png"></a></td>
	<td><p>세상의 모든 레시피</p></td>
</tr>

</table>
	
</div>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark">

<div class="w3-teal">
  <button id="openNav" class="w3-button w3-teal w3-xlarge" onclick="w3_open()">&#9776;</button>
  <div class="w3-container">
  </div>
</div>

&nbsp;&nbsp;&nbsp;

<a href="#" class="navbar-brand">세모레</a>

<!-- Toggle Button -->
<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
<span class="navbar-toggler-icon"></span>
</button>

<div class="collapse navbar-collapse" id="collapsibleNavbar">
<ul class="navbar-nav">
	<li class="nav-item"><a href="#" class="nav-link">공지사항</a></li>
	<li class="nav-item"><a href="/recipe/list" class="nav-link">게시판</a></li>
</ul>
</div>

</nav>

<div>

<c:if  test="${not login }">
<a href="/member/login">로그인</a>
</c:if>

<c:if  test="${login }">
<a href="/member/logout">로그아웃</a>
</c:if>

</div>

<!-- content -->
<div class="container pt-3" id="wrapper">