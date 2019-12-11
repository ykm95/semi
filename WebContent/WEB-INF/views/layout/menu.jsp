<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	background-color: #D8F6CE;
}

li{
	float: left;
}

li a{
	display: block;
	color: #000;
	padding : 8px 16px;
	text-align: center;
	text-decoration: none;
}

li a:hover:not(.active) {
    background-color: #555;
    color: white;
}
</style>

	<div id="menu">
		<ul>
			<li><a href="/admin/list">회원 목록</a></li>
			<li><a href="/question/list">1:1 문의관리</a></li>
			<li><a>게시글 관리</a></li>
			<li><a>신고글 관리</a></li>
		</ul>
	</div><br><br><br><br>