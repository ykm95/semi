<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/layout/headerAdmin.jsp"></jsp:include><br>
<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

		$("#btnanswer").click(function() {

			console.log(111);

			submitContents($("#btnanswer"));

			//form submit
			$("#write").submit();
		})

	});
</script>
<style type="text/css">
#question {
	background-color: white;
	width: 1100px;
	border: 3px #e9e9e9 solid;
}
#question1{
	border: 3px #e9e9e9 solid;
    width: 1065px;
    padding: 50px;
}

</style>
<body style="background-color:#f1f1f1;">
<!-- 	<div id="question"> -->
	<div class="col-md-12" style="text-align: center;">
	<h1>문의 답변</h1><br>
		<div id="question1" >${viewQuestion.question }</div>
	<div>
	<form id="write" action="/adminquestion/answer" method="POST">
		<textarea name="answer"></textarea>
		<script type="text/javascript">
			CKEDITOR.replace('answer', {
				height : 400
			});
		</script>
		<br> <input type="hidden" name="questionno"
			value="${viewQuestion.questionno }" /> <input type="hidden"
			name="userno" value="${viewQuestion.userno }" />
		<div class="text-center">
			<button type="submit" id="btnanswer" class="btn" style="background-color:#afd485">작성</button>
		</div><br>
	</form>
	</div>
	</div>
<!-- 	</div> -->
</body>
<jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>