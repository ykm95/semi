<%@page import="web.dto.Question"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	List<Question> list = (List) request.getAttribute("list");
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/layout/headerSearch.jsp" />

<script type="text/javascript">
	$(document).ready(function() {

		//알림 색상 변경
		$('#notice').mouseenter(function() {

			$(this).css('background', '#EEE')

		});
		$('#notice').mouseleave(function() {

			$(this).css('background', '#FFFFFF')

		});

		//문의 색상 변경
		$('#myrecipe').mouseenter(function() {

			$(this).css('background', '#EEE')

		});
		$('#myrecipe').mouseleave(function() {

			$(this).css('background', '#FFFFFF')

		});

		//스크랩 색상 변경
		$('#scrap').mouseenter(function() {

			$(this).css('background', '#EEE')

		});
		$('#scrap').mouseleave(function() {

			$(this).css('background', '#FFFFFF')

		});

		//행 색상 변경
		$('tr').mouseenter(function() {

			$(this).find('#name').css('background', '#EEE')

		});
		$('tr').mouseleave(function() {

			$(this).find('#name').css('background', '#FFFFFF')

		});

		//인사말 수정 버튼
		$('#usercom').mouseenter(function() {

			$(this).css('background', '#EEE');
			$('#comUpdate').removeAttr('hidden');

		});
		$('#usercom').mouseleave(function() {

			$(this).css('background', '#FFFFFF')
			$('#comUpdate').attr('hidden', 'hidden');

			$('#comment').removeAttr('hidden');
			$('#textarea').attr('hidden', 'hidden');

		});

		$('#btnComUpdate').click(function() {

			$('#comment').attr('hidden', 'hidden');
			$('#comUpdate').attr('hidden', 'hidden');

			$('#textarea').removeAttr('hidden');
		});
		
		
		//프로필사진 수정버튼
		$('#picupdate').click(function() {

			$('#picupdate').css('visibility', 'hidden');
			$('#submit').css('visibility', 'visible');
			$('#cancle').css('visibility', 'visible');

			$('#pic').removeAttr('hidden');
		});

		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#thumb').attr('src', e.target.result);
				}
				reader.readAsDataURL(input.files[0]);
			}
		}

		$("#inp").change(function() {
			readURL(this);
		});

	});
</script>


<style type="text/css">
table, th {
	text-align: center;
}

tr td:nth-child(2) {
	text-align: center;
}

.table>tbody>tr>td {
	padding: 10px;
	line-height: 1.428571;
	vertical-align: top;
	border-top: 1px solid #ccc;
}

.thumbnail {
	margin-bottom: 0px;
}
</style>

<div class="container">

	<div class="row">

		<div class="col-md-3" style="text-align: center;">
			<div>
				<img style="border: 2px solid #ccc" width="200px" height="200px"
					src="${member.userpic }" class="img-circle"> <br> <br>
				<div>
					<button id="picupdate" class="btn btn-xs">사진변경</button>
					<br>
					<br>
				</div>
				<form style="background: #EEE; padding: 20px;" id="pic"
					hidden="hidden" action="/mypage/user/picupdate" method="post"
					enctype="multipart/form-data">
					<img style="margin: 0 auto" height="150px" width="150px" id="thumb"
						class="thumbnail" src="#"> <br> <input
						style="width: 150px; margin: 0 auto" id="inp" type="file"
						name="file" accept="image/*"> <br>
					<button class="btn btn-xs btn-info">변경</button>
				</form>
			</div>
			<br>

			<h3>${member.nick }</h3>
			<br>
			<br>

			<div style="height: 100px; padding-top: 30px" id="usercom">
				<p id="comment">${member.usercom }</p>
				<p hidden="hidden" id="comUpdate">
					<button id="btnComUpdate" class="btn btn-xs">인사말 변경</button>
				</p>
				<form id="textarea" hidden="hidden" action="/mypage/user/comupdate"
					method="post">
					<textarea style="height: 60px; width: 150px;" name="usercom">${member.usercom }</textarea>
					<button class="btn btn-xs">변경</button>
				</form>
			</div>

			<br>

			<div style="text-align: right">
				<a href="/mypage/user/secession"><button
						class="btn btn-danger btn-xs">회원 탈퇴</button></a>
			</div>

			<hr>

			<div id="myrecipe">
				<a href="/mypage/myrecipe" style="font-size: x-large; color: black;">마이레시피</a>
			</div>
			<hr>

			<div id="notice">
				<a href="/mypage/notice" style="font-size: x-large; color: black;">알림</a>
			</div>
			<hr>

			<div id="scrap">
				<a href="/mypage/scrap" style="font-size: x-large; color: black;">스크랩</a>
			</div>
		</div>

		<div class="col-md-1">
			<div class="col-md-6"
				style="margin-bottom: 50px; border-right: 1px #ccc solid; height: 800px;"></div>
			<div class="col-md-6"></div>
		</div>

		<div class="col-md-8">

			<div style="margin-bottom: 50px;">
				<h1
					style="text-align: center; padding: 10px; margin: 0 auto 0; background: #AED584; color: white;">
					문의</h1>
			</div>

			<table class="table">

				<!-- 	<tr>
				<th style="width: 20%">문의상황</th>
				<th style="width: 80%">문의내역</th>
			</tr> -->

				<c:forEach items="${list }" var="i">
					<tr class="process">
						<c:if test="${empty i.answer }">
							<td style="background: #ccc; border: 1px white solid;">처리중</td>
						</c:if>
						<c:if test="${not empty i.answer }">
							<td style="background: skyblue; border: 1px white solid;">답변완료</td>
						</c:if>
						<td id="name" style="width: 80%"><a
							href="/mypage/question/view?questionno=${i.questionno }">${i.questitle }</a></td>
					</tr>
				</c:forEach>

			</table>

			<a href="/mypage/question/write"><button>문의 작성</button></a>
		</div>

	</div>
	<!-- row -->

</div>
<!-- container -->


<jsp:include page="/WEB-INF/views/layout/footer.jsp" />