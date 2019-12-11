<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>Recipe</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>


<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>





<script type="text/javascript">
$(document).ready(function() {


function deleteComment(commentno) {
	$.ajax({
		type: "post"
		, url: "/comment/delete"
		, dataType: "json"
		, data: {
			commentno: commentno
		}
		, success: function(data){
			if(data.success) {
				
				$("[data-commentno='"+commentno+"']").remove();
				
			} else {
				alert("댓글 삭제 실패");
			}
		}
		, error: function() {
			console.log("error");
		}
	});
}
</script>



<style type="text/css">
img {
	width: 600px;
	height: 400px;
}

body {
	padding-top: 20px;
	padding-bottom: 40px;
}

/* 전체 내용을 감쌈 */
.container-narrow {
	margin: 0 auto;
	max-width: 700px;
}

.container-narrow>hr {
	margin: 30px 0;
}

/* 핵심 마케팅 문구와 가입 버튼 */
.jumbotron {
	margin: 60px 0;
	text-align: center;
}

.jumbotron h1 {
	font-size: 72px;
	line-height: 1;
}

.jumbotron .btn {
	font-size: 21px;
	padding: 14px 24px;
}

/* 부수적인 마케팅 내용 */
.marketing {
	margin: 60px 0;
}

.marketing p+h4 {
	margin-top: 28px;
}
</style>

</head><body>


<div class="container-narrow">
<div class="masthead">
	<ul class="nav nav-pills pull-right">
	<li class="active"><a href="#">메인으로</a></li>
	<li><a href="#">목록</a></li>
	</ul>
	<h3 class="muted">${viewRecipe.recipename }</h3>
</div>
<hr>
	<div class="jumbotron">
	<img src="${viewRecipe.recipic }">
		<h1 class="lead">recipename: ${viewRecipe.recipename }</h1>
		<h3>recipeex: ${viewRecipe.recipeex }</h3>
		<br> <a class="btn btn-large btn-success" href="#">좋아요!</a>
	</div>
<hr>
<br><br><br><br>







	<div id="processDiv">		</div>









	<h1>레시피</h1>
	<div class="row-fluid marketing">
		<div class="span6">
		<h2>사진 1</h2>
		<p>운동을 할 수 있도록 쳇바퀴를 넣어 주는 것도 좋으며 케이지에 자동물병을 달아 준다.</p><br><br><br>

		<h2>사진 2</h2>
		<p>햄스터는 작은 틈으로도 도망을 치기 때문에, 구멍이 작은 케이지를 준비한다. 바닥에는 신문지 따위를 깔고
			이따금 갈아 넣어 준다.</p><br><br><br>

		<h2>사진 3</h2>				
		<p>서늘한 그늘에 놓아서 햇빛이 닿지 않고 바람이 잘 통하도록 해 준다.</p><br><br><br>

		<h2>사진 4</h2>
		<p>운동을 할 수 있도록 쳇바퀴를 넣어 주는 것도 좋으며 케이지에 자동물병을 달아 준다.</p><br><br><br>

		<h2>사진 5</h2>
		<p>햄스터는 작은 틈으로도 도망을 치기 때문에, 구멍이 작은 케이지를 준비한다. 바닥에는 신문지 따위를 깔고
		이따금 갈아 넣어 준다.</p><br><br><br>

		<h2>사진 6</h2>
		<p>서늘한 그늘에 놓아서 햇빛이 닿지 않고 바람이 잘 통하도록 해 준다.</p><br><br><br>
		</div><br><br><br><br><br>
	
<div id="commentbody"><br><br><br><br></div> <!-- 입력하고 새로고침되는 위치 -->
	<div style="text-align:center">
		<button><h2>좋아요</h2></button>
		<button><h2>신고</h2></button>
		<button id="btnScrap"></button>
	</div>	<hr><hr><hr>


<!-- 댓글 입력 -->
<div class="form-inline text-center" id="commentbody">
	<textarea rows="2" cols="60" class="form-control" id="commentContent"></textarea>
	<button id="btnCommInsert" class="btn">입력</button>
</div>	<!-- 댓글 입력 end -->

<!-- 댓글 리스트 -->
<table class="table table-striped table-hover table-condensed">

<thead>
<tr>
	<th style="width: 10%;">댓글 번호</th>
	<th style="width: 15%;">작성자 번호</th>
	<th style="width: 60%;">댓글</th>
	<th style="width: 15%;"></th>
</tr>
</thead>

<tbody id="commentBody">

	<c:forEach items="${commentList }" var="comment">
		<tr data-commentno="${comment.commentno }">
<%-- 			<td>${comment.commentno }</td>	 --%>
			<td>${comment.rownum }</td>	
			<td>${comment.userno }</td>	
			<td>${comment.comcontent }</td>	
	
			<td>
			<c:if test="${sessionScope.userno eq comment.userno }">
			<button class="btn btn-default btn-xs" onclick="deleteComment(${comment.commentno });">삭제</button>
			</c:if>
			</td>	
		</tr>
	</c:forEach>

</tbody>

</table> <!-- 댓글 리스트 end -->

</div><!-- 댓글 처리 end -->
	<hr>
	<div class="footer">
		<p>&copy; 세모레 2019</p>
	</div>
</div>
<!-- /container -->




<hr><hr><hr><hr><hr><hr><hr><hr><hr><hr><hr><hr><hr><hr><hr>
<h1>입력 데이터 확인용</h1>

<h3>recipeno: ${viewRecipe.recipeno }</h3>
<h3>userno: ${viewRecipe.userno }</h3>
<h3>recipename: ${viewRecipe.recipename }</h3>
<h3>recipeex: ${viewRecipe.recipeex }</h3>
<h3>recipic: <img src="${viewRecipe.recipic }"></h3>
<h3>category: ${viewRecipe.category }</h3>
<h3>ocassion: ${viewRecipe.ocassion }</h3>

</body>
</html>

