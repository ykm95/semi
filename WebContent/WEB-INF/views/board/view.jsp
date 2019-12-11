<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp"/>

<!-- 스타일 -->
<link href="../assets/css/bootstrap-ko.css" rel="stylesheet">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">

$(document).ready(function(){
	
	function chk() {
		
		$.ajax({
			type: "get"
			, url: "/recipe/scrap/chk"
			, data: {
				"recipeno": "${recipe.recipeno}"
			}
			, dataType: "json"
			, success: function(data) {
				
				if (data.result) {
					$("#btnScrap").html("<h2>스크랩취소</h2>");
				} else {
					$("#btnScrap").html("<h2>스크랩</h2>");
				}
				
			}
			
			, error: function(data) {
				console.log("실패")
			}
		})
				
	}
	
	
	chk();

	
	//스크랩버튼 동작
	$("#btnScrap").click(function(){
		$.ajax({
			type: "get"
			, url: "/recipe/scrap"
			, data: {
				"recipeno": "${recipe.recipeno}"
			}
			, dataType: "json"
			, success: function(data) {
				
				if (data.result) {
					$("#btnScrap").html("<h2>스크랩취소</h2>");
				} else {
					$("#btnScrap").html("<h2>스크랩</h2>");
				}
				
			}
			
			, error: function(data) {
				console.log("실패")
			}
		})
		
	});

	
	
});


</script>


<style type="text/css">
#mainpic {
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
<link href="../assets/css/bootstrap-responsive.css" rel="stylesheet">

<!-- IE6~8에서 HTML5 태그를 지원하기위한 HTML5 shim -->
<!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

<!-- 파비콘과 앱 아이콘 -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="../assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="../assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="../assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="../assets/ico/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon" href="../assets/ico/favicon.png">
</head>

<body>

<div class="container-narrow">
	<div class="masthead">
		<ul class="nav nav-pills pull-right">
			<li class="active"><a href="#">메인으로</a></li>
			<li><a href="#">목록</a></li>
		</ul>
		<h3 class="muted">${recipe.recipename }</h3>
	</div>
<hr>
	<div class="jumbotron">
	<img id="mainpic" src="${recipe.recipic }">
		<h1 class="lead">${recipe.recipename }</h1>
		<h3>${recipe.recipeex }</h3>
		<br> <a class="btn btn-large btn-success" href="#">좋아요!</a>
	</div>
<hr><br><br><br><br>
	
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
	
	<div style="text-align:center">
		<button><h2>좋아요</h2></button>
		<button><h2>신고</h2></button>
		<button id="btnScrap"></button>
	</div>			<hr><hr><hr>

	<div class="span6">
		<h1>댓글위치</h1>
		<p>운동을 할 수 있도록 쳇바퀴를 넣어 주는 것도 좋으며 케이지에 자동물병을 달아 준다.</p>
		</div>
	</div>			<hr>

	<div class="footer">
		<p>&copy; 회사 2013</p>
	</div>
</div>

	<!-- /container -->

	<!-- 자바스크립트
    ================================================== -->
	<!-- 페이지를 빨리 읽어들이도록 문서 마지막에 배치 -->
	<script src="../assets/js/jquery.js"></script>
	<script src="../assets/js/bootstrap-transition.js"></script>
	<script src="../assets/js/bootstrap-alert.js"></script>
	<script src="../assets/js/bootstrap-modal.js"></script>
	<script src="../assets/js/bootstrap-dropdown.js"></script>
	<script src="../assets/js/bootstrap-scrollspy.js"></script>
	<script src="../assets/js/bootstrap-tab.js"></script>
	<script src="../assets/js/bootstrap-tooltip.js"></script>
	<script src="../assets/js/bootstrap-popover.js"></script>
	<script src="../assets/js/bootstrap-button.js"></script>
	<script src="../assets/js/bootstrap-collapse.js"></script>
	<script src="../assets/js/bootstrap-carousel.js"></script>
	<script src="../assets/js/bootstrap-typeahead.js"></script>

</body>

<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>
